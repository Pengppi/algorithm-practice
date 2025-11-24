"""
Title: 3190.Find Minimum Operations to Make All Elements Divisible by Three
Title Slug: findMinimumOperationsToMakeAllElementsDivisibleByThree
Author: Neo
Date: 2025-11-22 10:14:13
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        return sum(1 for x in nums if x % 3)

# leetcode submit region end(Prohibit modification and deletion)
