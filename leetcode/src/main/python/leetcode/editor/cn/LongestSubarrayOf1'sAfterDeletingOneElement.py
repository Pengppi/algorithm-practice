"""
Title: 1493.Longest Subarray of 1's After Deleting One Element
Title Slug: longestSubarrayOf1sAfterDeletingOneElement
Author: Neo
Date: 2025-08-24 18:17:34
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        ans = 0
        l = cnt = 0
        for r, x, in enumerate(nums):
            if x == 0:
                cnt += 1
                while cnt > 1:
                    if nums[l] == 0:
                        cnt -= 1
                    l += 1
            ans = max(ans, r - l)

        return ans

        # leetcode submit region end(Prohibit modification and deletion)
