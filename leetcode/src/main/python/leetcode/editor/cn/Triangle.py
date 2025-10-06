"""
Title: 120.Triangle
Title Slug: triangle
Author: Neo
Date: 2025-09-25 12:33:56
"""
from functools import lru_cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle)

        @lru_cache
        def dfs(i: int, j: int) -> int:
            res = triangle[i][j]
            if i == n - 1:
                return res
            return res + min(dfs(i + 1, j), dfs(i + 1, j + 1))

        return dfs(0, 0)

# leetcode submit region end(Prohibit modification and deletion)
