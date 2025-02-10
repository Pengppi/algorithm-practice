"""
Title: 63.不同路径 II
Title Slug: uniquePathsIi
Author: Neo
Date: 2025-02-08 12:37:17
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1 or obstacleGrid[m - 1][n - 1] == 1:
            return 0

        @cache
        def dfs(x, y):
            if x == m - 1 and y == n - 1:
                return 1
            if x < 0 or x >= m or y < 0 or y >= n or obstacleGrid[x][y] == 1:
                return 0
            return dfs(x + 1, y) + dfs(x, y + 1)

        return dfs(0, 0)

# leetcode submit region end(Prohibit modification and deletion)
