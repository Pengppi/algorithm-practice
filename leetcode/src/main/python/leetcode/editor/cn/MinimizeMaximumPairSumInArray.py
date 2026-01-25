"""
Title: 1877.Minimize Maximum Pair Sum in Array
Title Slug: minimizeMaximumPairSumInArray
Author: Neo
Date: 2026-01-24 15:07:47
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        ans = 0
        for i in range(n // 2):
            ans = max(ans, nums[i] + nums[n - i - 1])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
