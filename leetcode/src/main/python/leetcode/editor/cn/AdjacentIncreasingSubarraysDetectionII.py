"""
Title: 3350.Adjacent Increasing Subarrays Detection II
Title Slug: adjacentIncreasingSubarraysDetectionIi
Author: Neo
Date: 2025-10-15 10:47:10
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxIncreasingSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        pre = cur = 0
        for i in range(n):
            if i > 0 and nums[i - 1] >= nums[i]:
                ans = max(ans, min(pre, cur), cur // 2)
                pre = cur
                cur = 0
            cur += 1
        ans = max(ans, min(pre, cur), cur // 2)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
