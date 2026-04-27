"""
Title: 2078.Two Furthest Houses With Different Colors
Title Slug: twoFurthestHousesWithDifferentColors
Author: Neo
Date: 2026-04-20 12:22:17
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        n = len(colors)

        @cache
        def dfs(i: int, j: int) -> int:
            if j <= i:
                return 0
            if colors[i] != colors[j]:
                return j - i
            else:
                return max(dfs(i + 1, j), dfs(i, j - 1))

        return dfs(0, n - 1)
# leetcode submit region end(Prohibit modification and deletion)
