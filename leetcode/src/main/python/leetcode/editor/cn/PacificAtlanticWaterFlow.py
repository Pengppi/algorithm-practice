"""
Title: 417.Pacific Atlantic Water Flow
Title Slug: pacificAtlanticWaterFlow
Author: Neo
Date: 2025-10-05 12:41:05
"""
from typing import List, Tuple, Set


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> list[tuple[int]]:
        m, n = len(heights), len(heights[0])
        dirs = [1, 0, -1, 0, 1]

        def func(p: List[Tuple[int]]) -> Set[Tuple[int]]:
            vis = set()

            def dfs(i: int, j: int) -> None:
                if (i, j) in vis:
                    return
                vis.add((i, j))
                for k in range(4):
                    x, y = i + dirs[k], j + dirs[k + 1]
                    if x < 0 or x >= m or y < 0 or y >= n or (x, y) in vis or heights[i][j] > heights[x][y]:
                        continue
                    dfs(x, y)

            for i, j in p:
                dfs(i, j)

            return vis

        pacific_points = [(i, j) for i in range(m) for j in range(n) if i == 0 or j == 0]
        atlantic_points = [(i, j) for i in range(m) for j in range(n) if i == m - 1 or j == n - 1]

        return list(func(pacific_points) & func(atlantic_points))

        # return ans

# leetcode submit region end(Prohibit modification and deletion)
