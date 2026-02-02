"""
Title: 1200.Minimum Absolute Difference
Title Slug: minimumAbsoluteDifference
Author: Neo
Date: 2026-01-26 12:29:55
"""

from itertools import pairwise
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        min_diff = min(arr[i] - arr[i - 1] for i in range(1, len(arr)))
        ans = []
        for a, b in pairwise(arr):
            if b - a == min_diff:
                ans.append([a, b])
        return ans


# leetcode submit region end(Prohibit modification and deletion)
