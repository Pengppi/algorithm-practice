"""
Title: 611.Valid Triangle Number
Title Slug: validTriangleNumber
Author: Neo
Date: 2025-09-26 17:19:24
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        ans = 0
        nums.sort()
        n = len(nums)
        for i in range(n - 2):
            for j in range(i + 1, n - 1):
                k = bisect.bisect_right(nums, lo=j + 1, x=nums[i] + nums[j] - 1)
                ans += k - j - 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)

Solution().triangleNumber([2, 2, 3, 4])
