"""
Title: 1266.Minimum Time Visiting All Points
Title Slug: minimumTimeVisitingAllPoints
Author: Neo
Date: 2026-01-12 12:24:58
"""

# leetcode submit region begin(Prohibit modification and deletion)
from itertools import pairwise
from typing import List


class Solution:

    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:

        def getSteps(x1: int, y1: int, x2: int, y2: int) -> int:
            dx, dy = abs(x1 - x2), abs(y1 - y2)
            return max(dx, dy)

        ans = 0
        for p1, p2 in pairwise(points):
            ans += getSteps(p1[0], p1[1], p2[0], p2[1])
        return ans


# leetcode submit region end(Prohibit modification and deletion)
