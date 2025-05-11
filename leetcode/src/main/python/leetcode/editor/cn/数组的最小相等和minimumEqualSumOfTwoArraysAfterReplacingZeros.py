"""
Title: 2918.数组的最小相等和
Title Slug: minimumEqualSumOfTwoArraysAfterReplacingZeros
Author: Neo
Date: 2025-05-10 15:05:27
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSum(self, nums1: List[int], nums2: List[int]) -> int:
        z1 = nums1.count(0)
        z2 = nums2.count(0)
        s1 = sum(nums1)
        s2 = sum(nums2)
        if z1 == 0 and z2 == 0:
            return -1 if s1 != s2 else s1
        elif z1 == 0:
            return -1 if s1 < s2 + z2 else s1
        elif z2 == 0:
            return -1 if s2 < s1 + z1 else s2

        return max(s1 + z1, s2 + z2)

# leetcode submit region end(Prohibit modification and deletion)
