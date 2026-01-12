"""
Title: 1458.Max Dot Product of Two Subsequences
Title Slug: maxDotProductOfTwoSubsequences
Author: Neo
Date: 2026-01-08 12:37:31
"""

# leetcode submit region begin(Prohibit modification and deletion)
from math import inf
from typing import List


class Solution:

    def maxDotProduct(self, nums1: List[int], nums2: List[int]) -> int:
        n1, n2 = len(nums1), len(nums2)
        f = [[-inf for _ in range(n2 + 1)] for _ in range(n1 + 1)]
        for i, x in enumerate(nums1):
            for j, y in enumerate(nums2):
                f[i + 1][j + 1] = max(
                    max(f[i][j], 0) + x * y, f[i][j + 1], f[i + 1][j])

        return f[n1][n2]


# leetcode submit region end(Prohibit modification and deletion)
