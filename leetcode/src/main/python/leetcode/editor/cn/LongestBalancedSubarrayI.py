"""
Title: 3719.Longest Balanced Subarray I
Title Slug: longestBalancedSubarrayI
Author: Neo
Date: 2026-02-10 14:32:09
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        ans = 0

        for i in range(len(nums)):
            odd = {}
            even = {}

            for j in range(i, len(nums)):
                if nums[j] & 1:
                    odd[nums[j]] = odd.get(nums[j], 0) + 1
                else:
                    even[nums[j]] = even.get(nums[j], 0) + 1

                if len(odd) == len(even):
                    ans = max(ans, j - i + 1)

        return ans

# leetcode submit region end(Prohibit modification and deletion)
