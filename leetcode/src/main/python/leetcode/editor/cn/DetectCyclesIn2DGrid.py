"""
Title: 1559.Detect Cycles in 2D Grid
Title Slug: detectCyclesIn2dGrid
Author: Neo
Date: 2026-04-26 10:44:54
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        dirs = [1, 0, -1, 0, 1]
        vis = [[False] * n for _ in range(m)]

        def dfs(i: int, j: int, pi: int, pj: int) -> bool:
            vis[i][j] = True
            for k in range(4):
                ni, nj = i + dirs[k], j + dirs[k + 1]
                if ni < 0 or ni >= m or nj < 0 or nj >= n or (ni, nj) == (pi, pj):
                    continue
                if grid[ni][nj] == grid[i][j]:
                    if vis[ni][nj] or dfs(ni, nj, i, j):
                        return True
            return False

        for i in range(m):
            for j in range(n):
                if not vis[i][j]:
                    if dfs(i, j, -1, -1):
                        return True

        return False

# leetcode submit region end(Prohibit modification and deletion)
# Solution().containsCycle([["a", "b", "b"], ["b", "z", "b"], ["b", "b", "a"]])
