"""
https://leetcode.cn/contest/weekly-contest-397
"""


from collections import defaultdict
from math import inf
from typing import List


class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ans = -inf
        for i in range(m - 2, -1, -1):
            ans = max(ans, grid[i + 1][n - 1] - grid[i][n - 1])
            grid[i][n - 1] = max(grid[i][n - 1], grid[i + 1][n - 1])
        for j in range(n - 2, -1, -1):
            ans = max(ans, grid[m - 1][j + 1] - grid[m - 1][j])
            grid[m - 1][j] = max(grid[m - 1][j], grid[m - 1][j + 1])

        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                mx = max(grid[i + 1][j], grid[i][j+1])
                ans = max(ans, mx - grid[i][j])
                grid[i][j] = max(mx, grid[i][j])
        return ans

    def maximumEnergy(self, energy: List[int], k: int) -> int:
        ans, n = -inf, len(energy)
        for i in range(n):
            if i >= k:
                energy[i] += max(0, energy[i - k])
            if i + k >= n:
                ans = max(energy[i], ans)
        return ans

    def findPermutationDifference(self, s: str, t: str) -> int:
        s_map = defaultdict(int)
        for i, c in enumerate(s):
            s_map[c] = i
        ans = 0
        for i, c in enumerate(t):
            ans += abs(i - s_map[c])
        return ans
