"""
Title: 718.最长重复子数组
Title Slug: maximumLengthOfRepeatedSubarray
Author: Neo
Date: 2024-05-03 23:15:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        m, n = len(nums1), len(nums2)
        f = [[0] * (n + 1) for _ in range(m + 1)]
        ans = 0
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                f[i][j] = f[i + 1][j + 1] + 1 if nums1[i] == nums2[j] else 0
                ans = max(ans, f[i][j])
        return ans

    # leetcode submit region end(Prohibit modification and deletion)
