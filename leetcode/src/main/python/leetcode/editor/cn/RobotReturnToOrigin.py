"""
Title: 657.Robot Return to Origin
Title Slug: robotReturnToOrigin
Author: Neo
Date: 2026-04-05 10:25:17
"""

# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def judgeCircle(self, moves: str) -> bool:
        x, y = 0, 0

        for c in moves:
            if c == "U":
                x += 1
            elif c == "D":
                x -= 1
            elif c == "L":
                y -= 1
            elif c == "R":
                y += 1
        return x == 0 and y == 0


# leetcode submit region end(Prohibit modification and deletion)
