"""
Title: 1498.Number of Subsequences That Satisfy the Given Sum Condition
Title Slug: numberOfSubsequencesThatSatisfyTheGivenSumCondition
Author: Neo
Date: 2025-06-29 23:04:26
"""
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
mod = 10 ** 9 + 7
N = 100_0000

pow2 = [1] * N
for i in range(1, N):
    pow2[i] = pow2[i - 1] * 2 % mod


class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        ans = 0
        l, r = 0, len(nums) - 1
        while l<=r:
            if nums[l] + nums[r] > target:
                r -= 1
            else:
                ans = (ans + pow2[r - l]) % mod
                l += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
