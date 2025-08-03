"""
Title: 3487.Maximum Unique Subarray Sum After Deletion
Title Slug: maximumUniqueSubarraySumAfterDeletion
Author: Neo
Date: 2025-07-25 09:47:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSum(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        ans = nums[0]
        n = len(nums)
        for i in range(1, n):
            if nums[i] <= 0:
                break
            if nums[i] == nums[i - 1]:
                continue
            ans += max(nums[i], 0)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
