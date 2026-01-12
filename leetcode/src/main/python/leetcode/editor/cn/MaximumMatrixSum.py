"""
Title: 1975.Maximum Matrix Sum
Title Slug: maximumMatrixSum
Author: Neo
Date: 2026-01-05 10:35:14
"""

# leetcode submit region begin(Prohibit modification and deletion)
from heapq import heapify, heappop, heappush
from math import inf
from typing import List


class Solution:

    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        tot = cnt = 0
        mn = inf
        for row in matrix:
            for x in row:
                if x < 0:
                    cnt += 1
                    x *= -1
                tot += x
                mn = min(mn, x)

        if cnt & 1:
            tot -= 2 * mn

        return tot


# leetcode submit region end(Prohibit modification and deletion)
Solution().maxMatrixSum([[10, -6, -6, -8], [-3, -7, -8, -9], [-4, -8, -5, -8],
                         [-9, -9, -6, -8]])
