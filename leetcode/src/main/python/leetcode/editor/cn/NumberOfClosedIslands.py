"""
Title: 1254.Number of Closed Islands
Title Slug: numberOfClosedIslands
Author: Neo
Date: 2025-08-17 16:43:58
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [0, -1, 0, 1, 0]

        def dfs(x, y):
            if x <= 0 or x >= m - 1 or y == 0 or y == n - 1:
                return False
            grid[x][y] = 1
            for k in range(4):
                nx, ny = x + dirs[k], y + dirs[k + 1]
                if grid[nx][ny] == 0 and not dfs(nx, ny):
                    grid[x][y] = 0
                    return False
            return True

        ans = 0
        for i in range(1, m - 1):
            for j in range(1, n - 1):
                if grid[i][j] == 0 and dfs(i, j):
                    ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
