"""
Title: 980.不同路径 III
Title Slug: uniquePathsIii
Author: Neo
Date: 2024-07-31 13:43:10
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = [0, -1, 0, 1, 0]

        @cache
        def dfs(x: int, y: int, mask: int) -> int:
            if grid[x][y] == 2:
                return 1 if bin(mask).count('1') == step_cnt else 0
            idx = x * n + y
            res = 0
            for k in range(4):
                nx = x + dirs[k]
                ny = y + dirs[k + 1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n or grid[nx][ny] == -1 or (mask >> idx) & 1:
                    continue
                res += dfs(nx, ny, mask | (1 << idx))
            return res

        x, y, step_cnt = 0, 0, 1
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    x, y = i, j
                elif grid[i][j] == 0:
                    step_cnt += 1
        return dfs(x, y, 0)

# leetcode submit region end(Prohibit modification and deletion)
