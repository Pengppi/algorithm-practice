"""
Title: 2708.一个小组的最大实力值
Title Slug: maximumStrengthOfAGroup
Author: Neo
Date: 2024-09-03 12:56:36
"""
from enum import IntEnum
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxStrength(self, nums: List[int]) -> int:
        mn, mx = nums[0], nums[0]
        for x in nums[1:]:
            mn, mx = min(mn, x, x * mn, x * mx), max(mx, x, x * mn, x * mx)
        return mx

# leetcode submit region end(Prohibit modification and deletion)
