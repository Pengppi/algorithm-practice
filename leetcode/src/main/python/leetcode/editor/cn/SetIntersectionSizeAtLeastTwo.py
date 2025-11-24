"""
Title: 757.Set Intersection Size At Least Two
Title Slug: setIntersectionSizeAtLeastTwo
Author: Neo
Date: 2025-11-20 18:15:09
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[1], -x[0]))
        s = e = -1
        ans = 0
        for a, b in intervals:
            if a <= s:
                continue
            if s < a <= e:
                s, e = e, b
                ans += 1
            if a > e:
                s, e = b - 1, b
                ans += 2
        return ans

# leetcode submit region end(Prohibit modification and deletion)
