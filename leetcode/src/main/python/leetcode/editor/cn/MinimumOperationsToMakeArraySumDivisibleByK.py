"""
Title: 3512.Minimum Operations to Make Array Sum Divisible by K
Title Slug: minimumOperationsToMakeArraySumDivisibleByK
Author: Neo
Date: 2025-11-29 12:58:54
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        return sum(nums) % k
# leetcode submit region end(Prohibit modification and deletion)

