"""
Title: 2419.Longest Subarray With Maximum Bitwise AND
Title Slug: longestSubarrayWithMaximumBitwiseAnd
Author: Neo
Date: 2025-07-30 12:47:14
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        cur = nums[0]
        le = 1
        ans = 1
        n = len(nums)
        mx = max(nums)
        for i in range(1, n):
            x = nums[i] & cur
            if x >= mx:
                cur = x
                le += 1
                ans = max(ans, le)
            else:
                cur = nums[i]
                le = 1
            mx = max(mx, cur)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().longestSubarray([100, 5, 5])
