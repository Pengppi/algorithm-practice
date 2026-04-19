"""
Title: 2463.Minimum Total Distance Traveled
Title Slug: minimumTotalDistanceTraveled
Author: Neo
Date: 2026-04-14 19:12:25
"""

from functools import cache
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort(key=lambda x: x[0])

        @cache
        def dp(fi: int, ri: int) -> int:
            if ri < 0:
                return 0
            if fi < 0:
                return inf  # pyright: ignore[reportReturnType]

            res = dp(fi - 1, ri)
            pos, limit = factory[fi]
            dist_sum = 0

            for k in range(min(ri + 1, limit)):
                new_ri = ri - k
                dist_sum += abs(robot[new_ri] - pos)
                res = min(res, dist_sum + dp(fi - 1, new_ri - 1))

            return res  # pyright: ignore[reportReturnType]

        return dp(len(factory) - 1, len(robot) - 1)


# leetcode submit region end(Prohibit modification and deletion)
