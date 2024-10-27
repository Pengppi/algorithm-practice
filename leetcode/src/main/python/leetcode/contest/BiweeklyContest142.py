import math
from collections import defaultdict
from copy import deepcopy
from linecache import cache
from typing import List


class Solution:
    def possibleStringCount(self, word: str) -> int:
        ans = 1
        for i, c in enumerate(word):
            if i > 0 and c == word[i - 1]:
                ans += 1
        return ans

    def findSubtreeSizes(self, parent: List[int], s: str) -> List[int]:
        g = defaultdict(list)
        ans = [1] * len(parent)
        for i, p in enumerate(parent):
            g[p].append(i)

        mp = dict()

        def dfs(x: int):
            c = s[x]
            fa = parent[x]
            old = -1
            if c in mp:
                old = mp[c]
            mp[c] = x
            for y in g[x]:
                dfs(y)
            if old != -1:
                ans[old] += ans[x]
                mp[c]=old
            elif fa != -1:
                ans[fa] += ans[x]
                del mp[c]

        dfs(0)
        return ans

    def maxScore(self, n: int, k: int, stayScore: List[List[int]], travelScore: List[List[int]]) -> int:

        @cache
        def dfs(i, j):
            if i == k:
                return 0
            res = stayScore[i][j] + dfs(i + 1, j)
            for dest, score in enumerate(travelScore[j]):
                res = max(res, score + dfs(i + 1, dest))
            return res

        ans = 0
        for i in range(n):
            ans = max(ans, dfs(0, i))
        dfs.cache_clear()
        return ans

    def possibleStringCount(self, word: str, k: int) -> int:
        n = len(word)
        if n == k:
            return 1
        repeat = 0
        for i, c in enumerate(word):
            if i > 0 and c == word[i - 1]:
                repeat += 1
        normal = n - repeat
        need = k - normal
        mod = 10 ** 9 + 7
        return (math.factorial(repeat) % mod // (math.factorial(repeat - need)) % mod) % mod
