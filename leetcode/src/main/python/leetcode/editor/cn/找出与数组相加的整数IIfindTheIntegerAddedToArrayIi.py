"""
Title: 3132.找出与数组相加的整数 II
Title Slug: findTheIntegerAddedToArrayIi
Author: Neo
Date: 2024-08-09 12:54:11
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumAddedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        nums1.sort()
        nums2.sort()

        for k in range(2, 0, -1):
            x = nums2[0] - nums1[k]
            j = 0
            for i in range(k, len(nums1)):
                if nums2[j] == nums1[i] + x:
                    j += 1
                    if j == len(nums2):
                        return x
        return nums2[0] - nums1[0]
# leetcode submit region end(Prohibit modification and deletion)
