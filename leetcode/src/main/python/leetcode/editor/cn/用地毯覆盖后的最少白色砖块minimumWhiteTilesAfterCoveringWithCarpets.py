"""
Title: 2209.用地毯覆盖后的最少白色砖块
Title Slug: minimumWhiteTilesAfterCoveringWithCarpets
Author: Neo
Date: 2025-02-21 13:20:33
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumWhiteTiles(self, floor: str, numCarpets: int, carpetLen: int) -> int:
        if numCarpets * carpetLen >= len(floor):
            return 0

        @cache
        def dp(i, c):
            if i >= len(floor):
                return 0
            if floor[i] == '0':
                return dp(i + 1, c)
            if c == 0:
                return dp(i + 1, c) + 1
            return min(dp(i + 1, c) + 1, dp(i + carpetLen, c - 1))

        return dp(0, numCarpets)
# leetcode submit region end(Prohibit modification and deletion)
