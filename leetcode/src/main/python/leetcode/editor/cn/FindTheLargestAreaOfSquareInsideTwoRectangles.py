"""
Title: 3047.Find the Largest Area of Square Inside Two Rectangles
Title Slug: findTheLargestAreaOfSquareInsideTwoRectangles
Author: Neo
Date: 2026-01-17 15:51:29
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def largestSquareArea(
        self, bottomLeft: List[List[int]], topRight: List[List[int]]
    ) -> int:
        mxLen = 0
        for i, ((bx1, by1), (tx1, ty1)) in enumerate(zip(bottomLeft, topRight)):
            for j in range(i):
                bx = max(bx1, bottomLeft[j][0])
                by = max(by1, bottomLeft[j][1])
                tx = min(tx1, topRight[j][0])
                ty = min(ty1, topRight[j][1])
                w = ty - by
                h = tx - bx
                mxLen = max(mxLen, min(w, h))

        return mxLen * mxLen


# leetcode submit region end(P`rohibit modification and deletion)
