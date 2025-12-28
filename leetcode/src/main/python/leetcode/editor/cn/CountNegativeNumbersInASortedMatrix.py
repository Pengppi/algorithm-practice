"""
Title: 1351.Count Negative Numbers in a Sorted Matrix
Title Slug: countNegativeNumbersInASortedMatrix
Author: Neo
Date: 2025-12-28 11:35:28
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def countNegatives(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        ans = 0
        i = 0
        j = n - 1
        while i < m and j >= 0:
            if grid[i][j] < 0:
                ans += m - i
                j -= 1
            else:
                i += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
