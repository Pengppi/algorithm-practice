"""
Title: 1594.Maximum Non Negative Product in a Matrix
Title Slug: maximumNonNegativeProductInAMatrix
Author: Neo
Date: 2026-03-23 11:16:07
"""

# leetcode submit region begin(Prohibit modification and deletion)
from functools import cache
from math import inf
from typing import List, Tuple


class Solution:
    def maxProductPath(self, grid: List[List[int]]) -> int:
        mod = 10**9 + 7
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(i: int, j: int) -> Tuple[int, int]:
            g = grid[i][j]
            if i == 0 and j == 0:
                return g, g

            res_min, res_max = inf, -inf
            if i > 0:
                mn, mx = dfs(i - 1, j)
                res_max = max(g * mn, g * mx)
                res_min = min(g * mn, g * mx)
            if j > 0:
                mn, mx = dfs(i, j - 1)
                res_max = max(res_max, g * mn, g * mx)
                res_min = min(res_min, g * mn, g * mx)

            return res_min, res_max

        ans = dfs(m - 1, n - 1)[1]
        return -1 if ans < 0 else ans % mod


# leetcode submit region end(Prohibit modification and deletion)
Solution().maxProductPath([[1, 3], [0, -4]])
