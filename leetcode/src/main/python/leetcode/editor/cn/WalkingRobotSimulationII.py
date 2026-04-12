"""
Title: 2069.Walking Robot Simulation II
Title Slug: walkingRobotSimulationIi
Author: Neo
Date: 2026-04-07 12:26:56
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Robot:
    dir_words = ["North", "East", "South", "West"]
    dirs = [0, 1, 0, -1, 0]

    def __init__(self, width: int, height: int):
        self.m, self.n = width, height
        self.x, self.y = 0, 0
        self.k = 1
        self.circumference = 2 * (width + height - 2)
        self.move = 0

    def step(self, num: int) -> None:
        self.move += num
        self.move = (self.move - 1) % self.circumference + 1

    def startMove(self) -> None:
        if self.move == 0:
            return
        i, j = self.x, self.y
        for _ in range(self.move):
            ni, nj = i + Robot.dirs[self.k], j + Robot.dirs[self.k + 1]
            while ni < 0 or ni >= self.m or nj < 0 or nj >= self.n:
                self.k = (self.k + 3) % 4
                ni, nj = i + Robot.dirs[self.k], j + Robot.dirs[self.k + 1]
            i, j = ni, nj
        self.x, self.y = i, j
        self.move = 0

    def getPos(self) -> List[int]:
        self.startMove()
        return [self.x, self.y]

    def getDir(self) -> str:
        self.startMove()
        return Robot.dir_words[self.k]


# Your Robot object will be instantiated and called as such:
# obj = Robot(width, height)
# obj.step(num)
# param_2 = obj.getPos()
# param_3 = obj.getDir()
# leetcode submit region end(Prohibit modification and deletion)
