"""
Title: 3131.找出与数组相加的整数 I
Title Slug: findTheIntegerAddedToArrayI
Author: Neo
Date: 2024-08-08 12:24:58
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def addedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        return min(nums2) - min(nums1)

# leetcode submit region end(Prohibit modification and deletion)
