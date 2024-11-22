"""
Title: 3248.矩阵中的蛇
Title Slug: snakeInMatrix
Author: Neo
Date: 2024-11-21 12:11:25
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def finalPositionOfSnake(self, n: int, commands: List[str]) -> int:
        x, y = 0, 0
        for c in commands:
            if c == 'UP':
                y -= 1
            elif c == "DOWN":
                y += 1
            elif c == 'RIGHT':
                x += 1
            else:
                x -= 1
        return y * n + x
# leetcode submit region end(Prohibit modification and deletion)
