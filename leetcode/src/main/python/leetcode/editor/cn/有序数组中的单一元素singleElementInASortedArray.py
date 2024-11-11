"""
Title: 540.有序数组中的单一元素
Title Slug: singleElementInASortedArray
Author: Neo
Date: 2024-11-10 13:57:46
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        l, r = 0, len(nums) // 2
        while l < r:
            m = (l + r) >> 1
            if nums[m * 2] != nums[m * 2 + 1]:
                r = m
            else:
                l = m + 1
        return nums[r * 2]
# leetcode submit region end(Prohibit modification and deletion)
