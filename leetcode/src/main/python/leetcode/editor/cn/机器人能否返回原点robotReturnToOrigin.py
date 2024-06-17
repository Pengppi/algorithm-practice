"""
Title: 657.机器人能否返回原点
Title Slug: robotReturnToOrigin
Author: Neo
Date: 2024-06-15 12:25:02
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def judgeCircle(self, moves: str) -> bool:
        horizontal, vertical = 0, 0
        for move in moves:
            if move == 'U':
                vertical += 1
            elif move == 'D':
                vertical -= 1
            elif move == 'L':
                horizontal -= 1
            elif move == 'R':
                horizontal += 1
        return not horizontal and not vertical
# leetcode submit region end(Prohibit modification and deletion)
