from cmath import inf
from collections import defaultdict
from functools import cache
from typing import List


class Solution:
    def getEncryptedString(self, s: str, k: int) -> str:
        k %= len(s)
        return s[k:] + s[:k]

    def validStrings(self, n: int) -> List[str]:
        ans = []

        def dfs(x: int, last: int, s: str) -> None:
            if x == n:
                ans.append(s)
                return
            if last == 0:
                dfs(x + 1, 1, s + '1')
            else:
                dfs(x + 1, 0, s + '0')
                dfs(x + 1, 1, s + '1')

        dfs(0, 1, "")
        return ans

    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        rf = [False] * m
        cf = [False] * n

        ans = 0
        import numpy as np
        preSum = np.zeros((m + 1, n + 1))
        xSum = np.zeros((m + 1, n + 1))
        for i in range(m):
            for j in range(n):
                f = 0
                xf = 0
                if grid[i][j] == 'X':
                    rf[i] = True
                    cf[j] = True
                    f = 1
                    xf = 1
                elif grid[i][j] == 'Y':
                    f = -1
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + f
                xSum[i + 1][j + 1] = xSum[i + 1][j] + xSum[i][j + 1] - xSum[i][j] + xf
                if preSum[i + 1][j + 1] == 0 and xSum[i + 1][j + 1] > 0:
                    ans += 1
        return ans

    def minimumCost(self, target: str, words: List[str], costs: List[int]) -> int:
        mp = defaultdict(lambda: inf)
        for i, w in enumerate(words):
            mp[w] = min(costs[i], mp[w])

        @cache
        def dfs(t: str) -> int:
            n = len(t)
            if n == 0:
                return 0
            res = inf
            for i in range(1, n + 1):
                pre = t[:i]
                if pre in mp:
                    res = min(res, mp[pre] + dfs(t[i:]))
            return res

        ans = dfs(target)
        return -1 if ans == inf else ans


Solution().minimumCost("abcdef", ["abdef", "abc", "d", "def", "ef"], [100, 1, 1, 10, 5])
