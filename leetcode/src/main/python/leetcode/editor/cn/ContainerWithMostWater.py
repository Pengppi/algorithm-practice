"""
Title: 11.Container With Most Water
Title Slug: containerWithMostWater
Author: Neo
Date: 2025-10-04 10:19:56
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxArea(self, height: List[int]) -> int:
        n = len(height)
        l, r = 0, n - 1
        ans = 0
        while l < r:
            ans = max(ans,min(height[l],height[r])*(r-l))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
