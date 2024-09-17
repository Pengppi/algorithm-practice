from collections import Counter
from functools import lru_cache
from linecache import cache
from math import inf
from typing import List


class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        cnt = Counter(nums)
        ans = [x for x, c in cnt.items() if c == 2]
        return ans

    def maxScore(self, a: List[int], b: List[int]) -> int:
        n = len(b)
        ans = -inf
        mx = [-inf] * 4
        mx[0] = a[0] * b[0]
        for i in range(1, n):
            for j in range(3, 0, -1):
                if j > i:
                    continue
                mx[j] = max(mx[j], mx[j - 1] + a[j] * b[i])
            mx[0] = max(mx[0], a[0] * b[i])
            ans = max(ans, mx[3])
        return ans

    def minValidStrings(self, words: List[str], target: str) -> int:
        class Tire:
            def __init__(self):
                self.children = {}

            def insert(self, word: str):
                node = self
                for c in word:
                    if c not in node.children:
                        node.children[c] = Tire()
                    node = node.children[c]

        root = Tire()
        for word in words:
            root.insert(word)
        n = len(target)

        @lru_cache(None)
        def dfs(x):
            if target[x] not in root.children:
                return inf
            node = root.children[target[x]]
            i = x + 1
            idx = []
            while i < n:
                c = target[i]
                if c in root.children:
                    idx.append(i)
                if c not in node.children:
                    break
                node = node.children[c]
                i += 1
            if i == n:
                return 1
            res = inf
            for j in idx:
                res = min(res, dfs(j) + 1)
            return res

        ans = dfs(0)
        dfs.cache_clear()
        return -1 if ans == inf else ans
