"""
Title: 3381.Maximum Subarray Sum With Length Divisible by K
Title Slug: maximumSubarraySumWithLengthDivisibleByK
Author: Neo
Date: 2025-11-27 13:05:01
"""
from itertools import accumulate


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ps = list(accumulate(nums, initial=0))
        mns = [inf] * k
        ans = -inf
        for j, s in enumerate(ps):
            i = j % k
            ans = max(ans, s - mns[i])
            mns[i] = min(mns[i], s)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
