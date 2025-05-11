"""
Title: 1920.基于排列构建数组
Title Slug: buildArrayFromPermutation
Author: Neo
Date: 2025-05-06 12:30:35
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        return [nums[nums[i]] for i in range(len(nums))]

# leetcode submit region end(Prohibit modification and deletion)
