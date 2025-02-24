"""
Title: 624.数组列表中的最大距离
Title Slug: maximumDistanceInArrays
Author: Neo
Date: 2025-02-19 14:10:36
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        mn, mx = inf, -inf
        ans = 0
        for arr in arrays:
            ans = max(ans, mx - arr[0], arr[-1] - mn)
            mn = min(mn, arr[0])
            mx = max(mx, arr[-1])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
