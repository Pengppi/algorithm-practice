"""
Title: 3102.最小化曼哈顿距离
Title Slug: minimizeManhattanDistances
Author: Neo
Date: 2024-07-09 12:17:09
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumDistance(self, points: List[List[int]]) -> int:
        def compareMax(mx: List[int], x) -> None:
            if x > mx[0]:
                mx[0], mx[1] = x, mx[0]
            elif x > mx[1]:
                mx[1] = x

        def compareMin(mn: List[int], x) -> None:
            if x < mn[0]:
                mn[0], mn[1] = x, mn[0]
            elif x < mn[1]:
                mn[1] = x

        mxX, mxY = [-inf, -inf], [-inf, -inf]
        mnX, mnY = [inf, inf], [inf, inf]
        for (i, j) in points:
            x, y = i + j, j - i
            compareMax(mxX, x)
            compareMax(mxY, y)
            compareMin(mnX, x)
            compareMin(mnY, y)

        ans = inf
        for (i, j) in points:
            x, y = i + j, j - i
            dx = (mxX[1] if x == mxX[0] else mxX[0]) - (mnX[1] if x == mnX[0] else mnX[0])
            dy = (mxY[1] if y == mxY[0] else mxY[0]) - (mnY[1] if y == mnY[0] else mnY[0])
            ans = min(ans, max(dx, dy))
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().minimumDistance([[3, 10], [5, 15], [10, 2], [4, 4]])
