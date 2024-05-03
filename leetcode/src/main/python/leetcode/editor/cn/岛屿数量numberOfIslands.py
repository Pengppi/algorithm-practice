"""
Title: 200.岛屿数量
Title Slug: numberOfIslands
Author: Neo
Date: 2024-05-03 00:37:55
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        dirs = [1, 0, -1, 0, 1]
        m, n = len(grid), len(grid[0])

        def dfs(x: int, y: int) -> bool:
            if grid[x][y] != '1':
                return False
            grid[x][y] = '0'
            for i in range(4):
                nx, ny = x + dirs[i], y + dirs[i + 1]
                if m > nx >= 0 and n > ny >= 0 and grid[nx][ny] == '1':
                    dfs(nx, ny)
            return True

        ans = 0
        for i in range(m):
            for j in range(n):
                if dfs(i, j):
                    ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
