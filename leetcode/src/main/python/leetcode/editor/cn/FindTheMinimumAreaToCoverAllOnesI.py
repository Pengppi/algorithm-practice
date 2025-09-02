"""
Title: 3195.Find the Minimum Area to Cover All Ones I
Title Slug: findTheMinimumAreaToCoverAllOnesI
Author: Neo
Date: 2025-08-22 18:37:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        top, bottom = m, -1
        left, right = n, -1
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    top = min(top, i)
                    bottom = max(bottom, i)
                    left = min(left, j)
                    right = max(right, j)
        
        return (bottom - top + 1) * (right - left + 1)


# leetcode submit region end(Prohibit modification and deletion)
Solution().minimumArea([[0, 1, 0], [1, 0, 1]])
