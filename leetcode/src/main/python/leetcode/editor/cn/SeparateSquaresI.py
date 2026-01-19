"""
Title: 3453.Separate Squares I
Title Slug: separateSquaresI
Author: Neo
Date: 2026-01-13 12:29:41
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict
from itertools import pairwise
from typing import List


class Solution:

    def separateSquares(self, squares: List[List[int]]) -> float:
        totArea = 0
        diff = defaultdict(int)
        for x, y, l in squares:
            totArea += l * l
            diff[y] += l
            diff[y + l] -= l

        curArea = curL = 0
        for y1, y2 in pairwise(sorted(diff)):
            curL += diff[y1]
            curArea += curL * (y2 - y1)
            if curArea * 2 >= totArea:
                return y2 - (curArea * 2 - totArea) / 2 / curL

        return -1


# leetcode submit region end(Prohibit modification and deletion)
