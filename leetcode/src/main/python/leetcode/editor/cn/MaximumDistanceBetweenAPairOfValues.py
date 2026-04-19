"""
Title: 1855.Maximum Distance Between a Pair of Values
Title Slug: maximumDistanceBetweenAPairOfValues
Author: Neo
Date: 2026-04-19 11:40:51
"""

from bisect import bisect_left
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        n = min(len(nums1), len(nums2))
        if len(nums1) > len(nums2):
            nums1 = nums1[:n][::-1]
            nums2 = nums2[:n][::-1]
            pivot = 0
        else:
            nums1 = nums1[::-1]
            nums2 = nums2[::-1]
            pivot = len(nums2) - len(nums1)

        ans = 0
        for i in range(n):
            x1, x2 = nums1[i], nums2[i + pivot]
            if x1 > x2:
                continue
            j = bisect_left(nums2, hi=i + pivot + 1, x=x1)
            ans = max(ans, i + pivot - j)
        return ans


# leetcode submit region end(Prohibit modification and deletion)

solution = Solution()
solution.maxDistance([30, 29, 19, 5],
                     [25, 25, 25, 25, 25])
