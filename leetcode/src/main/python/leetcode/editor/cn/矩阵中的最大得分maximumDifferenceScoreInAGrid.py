"""
Title: 3148.矩阵中的最大得分
Title Slug: maximumDifferenceScoreInAGrid
Author: Neo
Date: 2024-08-15 13:41:38
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
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
                mx = max(grid[i + 1][j], grid[i][j + 1])
                ans = max(ans, mx - grid[i][j])
                grid[i][j] = max(mx, grid[i][j])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
