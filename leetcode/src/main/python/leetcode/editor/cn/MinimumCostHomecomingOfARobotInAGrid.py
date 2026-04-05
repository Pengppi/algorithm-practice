"""
Title: 2087.Minimum Cost Homecoming of a Robot in a Grid
Title Slug: minimumCostHomecomingOfARobotInAGrid
Author: Neo
Date: 2026-04-04 15:30:14
"""

from functools import cache
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCost(
        self,
        startPos: List[int],
        homePos: List[int],
        rowCosts: List[int],
        colCosts: List[int],
    ) -> int:

        ans = 0
        while startPos != homePos:
            i1, j1 = startPos
            i2, j2 = homePos
            if i1 < i2:
                ans += rowCosts[i1 + 1]
                i1 += 1
            elif i1 > i2:
                ans += rowCosts[i1 - 1]
                i1 -= 1
            if j1 < j2:
                ans += colCosts[j1 + 1]
                j1 += 1
            elif j1 > j2:
                ans += colCosts[j1 - 1]
                j1 -= 1
            startPos = [i1, j1]

        return ans


# leetcode submit region end(Prohibit modification and deletion)
