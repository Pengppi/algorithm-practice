"""
Title: 3000.Maximum Area of Longest Diagonal Rectangle
Title Slug: maximumAreaOfLongestDiagonalRectangle
Author: Neo
Date: 2025-08-26 12:39:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def areaOfMaxDiagonal(self, dimensions: List[List[int]]) -> int:
        ans = 0
        longest = 0
        for rec in dimensions:
            l, w = rec
            cur_diag = l * l + w * w
            cur_area = l * w
            if cur_diag > longest:
                longest = cur_diag
                ans = cur_area
            elif cur_diag == longest and cur_area > ans:
                longest = cur_diag
                ans = cur_area
        return ans

# leetcode submit region end(Prohibit modification and deletion)
