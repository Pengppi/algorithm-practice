"""
Title: 3661.Maximum Walls Destroyed by Robots
Title Slug: maximumWallsDestroyedByRobots
Author: Neo
Date: 2026-04-03 12:30:19
"""

# leetcode submit region begin(Prohibit modification and deletion)
from bisect import bisect, bisect_left, bisect_right
from functools import cache
from typing import List


class Solution:
    def maxWalls(self, robots: List[int], distance: List[int], walls: List[int]) -> int:
        n = len(robots)
        walls.sort()
        a = sorted(zip(robots, distance), key=lambda o: o[0])

        @cache
        def dfs(i: int, j: int) -> int:
            if i < 0:
                return 0
            # left
            left = a[i][0] - a[i][1]
            if i > 0:
                left = max(left, a[i - 1][0] + 1)
            left_wall = bisect_left(walls, left)
            right_wall = bisect_right(walls, a[i][0])
            res_left = right_wall - left_wall + dfs(i - 1, 0)

            # right
            right = a[i][0] + a[i][1]
            if i < n - 1:
                right = min(right, a[i + 1][0] - 1)
                if j == 0:
                    right = min(right, a[i + 1][0] - a[i + 1][1] - 1)
            left_wall = bisect_left(walls, a[i][0])
            right_wall = bisect_right(walls, right)
            res_right = right_wall - left_wall + dfs(i - 1, 1)
            return max(res_left, res_right)

        return dfs(n - 1, 1)

# leetcode submit region end(Prohibit modification and deletion)
