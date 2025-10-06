"""
Title: 812.Largest Triangle Area
Title Slug: largestTriangleArea
Author: Neo
Date: 2025-09-27 10:06:25
"""
from itertools import combinations
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestTriangleArea(self, points: List[List[int]]) -> float:
        ans = 0
        for p1, p2, p3 in combinations(points, 3):
            x1, y1 = p2[0] - p1[0], p2[1] - p1[1]
            x2, y2 = p3[0] - p1[0], p3[1] - p1[1]
            ans = max(ans, abs(x1 * y2 - x2 * y1))

        return ans / 2

# leetcode submit region end(Prohibit modification and deletion)
