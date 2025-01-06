"""
Title: 1401.圆和矩形是否有重叠
Title Slug: circleAndRectangleOverlapping
Author: Neo
Date: 2025-01-01 17:16:17
"""
import math


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkOverlap(self, radius: int, xCenter: int, yCenter: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        def getClosest(x: int, x1: int, x2: int) -> int:
            if x1 <= x <= x2:
                return x
            if x < x1:
                return x1
            return x2

        x = getClosest(xCenter, x1, x2)
        y = getClosest(yCenter, y1, y2)
        return math.dist([x, y], [xCenter, yCenter]) <= radius

# leetcode submit region end(Prohibit modification and deletion)
