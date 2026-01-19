"""
Title: 2943.Maximize Area of Square Hole in Grid
Title Slug: maximizeAreaOfSquareHoleInGrid
Author: Neo
Date: 2026-01-15 12:31:08
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def maximizeSquareHoleArea(
            self, n: int, m: int, hBars: List[int], vBars: List[int]
    ) -> int:
        def findLongestContinuesLen(arr: List[int]) -> int:
            res = 0
            left = 0
            for right in range(1, len(arr)):
                if arr[right] != arr[right - 1] + 1:
                    res = max(res, right - left)
                    left = right
            res = max(res, len(arr) - left)
            return res

        hLen = findLongestContinuesLen(sorted(hBars))
        vLen = findLongestContinuesLen(sorted(vBars))
        return (min(hLen, vLen) + 1) ** 2


# leetcode submit region end(Prohibit modification and deletion)
Solution().maximizeSquareHoleArea(2, 1, [2, 3], [2])
