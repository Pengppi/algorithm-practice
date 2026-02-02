"""
Title: 3010.Divide an Array Into Subarrays With Minimum Cost I
Title Slug: divideAnArrayIntoSubarraysWithMinimumCostI
Author: Neo
Date: 2026-02-01 22:14:10
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minimumCost(self, nums: List[int]) -> int:
        return nums[0] + sum(sorted(nums[1:])[:2])


# leetcode submit region end(Prohibit modification and deletion)
