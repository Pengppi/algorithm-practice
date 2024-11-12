"""
Title: 3235.判断矩形的两个角落是否可达
Title Slug: checkIfTheRectangleCornerIsReachable
Author: Neo
Date: 2024-11-08 12:22:19
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canReachCorner(self, X: int, Y: int, circles: List[List[int]]) -> bool:
        def in_circle(ox: int, oy: int, r: int, x: int, y: int) -> bool:
            return (ox - x) * (ox - x) + (oy - y) * (oy - y) <= r * r

        vis = [False] * len(circles)
        def dfs(i: int) -> bool:
            x1, y1, r1 = circles[i]
            if y1 <= Y and abs(x1 - X) <= r1 or \
                    x1 <= X and y1 <= r1 or \
                    x1 > X and in_circle(x1, y1, r1, X, 0):
                return True
            vis[i] = True
            for j, (x2, y2, r2) in enumerate(circles):
                if not vis[j] and \
                        (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= (r1 + r2) * (r1 + r2) and \
                        x1 * r2 + x2 * r1 < (r1 + r2) * X and \
                        y1 * r2 + y2 * r1 < (r1 + r2) * Y and \
                        dfs(j):
                    return True
            return False

        for i, (x, y, r) in enumerate(circles):
            if in_circle(x, y, r, 0, 0) or \
                    in_circle(x, y, r, X, Y) or \
                    not vis[i] and (x <= X and abs(y - Y) <= r or
                                    y <= Y and x <= r or
                                    y > Y and in_circle(x, y, r, 0, Y)) and dfs(i):
                return False
        return True

# leetcode submit region end(Prohibit modification and deletion)
