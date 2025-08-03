"""
Title: 2411.Smallest Subarrays With Maximum Bitwise OR
Title Slug: smallestSubarraysWithMaximumBitwiseOr
Author: Neo
Date: 2025-07-29 18:41:49
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [1] * n
        for i, x in enumerate(nums):
            for j in range(i - 1, -1, -1):
                if nums[j] | x == nums[j]:
                    break
                nums[j] |= x
                ans[j] = i - j + 1

        return ans
# leetcode submit region end(Prohibit modification and deletion)
