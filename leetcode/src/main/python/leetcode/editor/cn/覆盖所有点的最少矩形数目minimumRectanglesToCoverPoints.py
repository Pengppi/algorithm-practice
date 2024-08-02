"""
Title: 3111.覆盖所有点的最少矩形数目
Title Slug: minimumRectanglesToCoverPoints
Author: Neo
Date: 2024-07-31 12:29:58
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minRectanglesToCoverPoints(self, points: List[List[int]], w: int) -> int:
        ans = 0
        last = -1
        points.sort(key=lambda p: p[0])
        for i, (x, y) in enumerate(points):
            if last == -1:
                last = x
                ans += 1
            elif x - last > w:
                ans += 1
                last = x

        return ans
    # leetcode submit region end(Prohibit modification and deletion)
