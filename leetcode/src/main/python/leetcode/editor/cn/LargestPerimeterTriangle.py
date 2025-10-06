"""
Title: 976.Largest Perimeter Triangle
Title Slug: largestPerimeterTriangle
Author: Neo
Date: 2025-09-28 12:44:18
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        n = len(nums)
        for i in range(n - 2):
            a, b, c = nums[i:i + 3]
            if a < b + c:
                return a + b + c
        return 0
# leetcode submit region end(Prohibit modification and deletion)
