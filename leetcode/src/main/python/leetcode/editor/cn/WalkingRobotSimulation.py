"""
Title: 874.Walking Robot Simulation
Title Slug: walkingRobotSimulation
Author: Neo
Date: 2026-04-06 10:51:17
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dirs = [0, 1, 0, -1, 0]
        obstacle_set = set(map(tuple, obstacles))
        ans = k = 0
        x, y = 0, 0
        for c in commands:
            if c == -1:
                k = (k + 1) % 4
            elif c == -2:
                k = (k + 3) % 4
            else:
                for _ in range(c):
                    nx, ny = x + dirs[k], y + dirs[k + 1]
                    if (nx, ny) in obstacle_set:
                        break
                    x, y = nx, ny
                ans = max(ans, x * x + y * y)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
