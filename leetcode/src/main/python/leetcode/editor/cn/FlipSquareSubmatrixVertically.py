"""
Title: 3643.Flip Square Submatrix Vertically
Title Slug: flipSquareSubmatrixVertically
Author: Neo
Date: 2026-03-21 13:10:07
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseSubmatrix(
        self, grid: List[List[int]], x: int, y: int, k: int
    ) -> List[List[int]]:

        i1 = x
        i2 = x + k - 1
        while i1 < i2:
            grid[i1][y : y + k], grid[i2][y : y + k] = (
                grid[i2][y : y + k],
                grid[i1][y : y + k],
            )
            i1 += 1
            i2 -= 1
        return grid


# leetcode submit region end(Prohibit modification and deletion)

