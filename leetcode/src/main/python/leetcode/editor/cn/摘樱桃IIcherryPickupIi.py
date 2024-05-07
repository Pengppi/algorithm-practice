"""
Title: 1463.摘樱桃 II
Title Slug: cherryPickupIi
Author: Neo
Date: 2024-05-07 14:21:40
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(k: int, i: int, j: int) -> int:
            if i >= n or i < 0 or j >= n or j < 0 or k >= m:
                return 0
            return (max(dfs(k + 1, i2, j2) for i2 in (i - 1, i, i + 1) for j2 in (j - 1, j, j + 1))
                    + grid[k][i] + (grid[k][j] if j != i else 0))

        return dfs(0, 0, n - 1)

# leetcode submit region end(Prohibit modification and deletion)
