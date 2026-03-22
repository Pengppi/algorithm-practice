"""
Title: 1727.Largest Submatrix With Rearrangements
Title Slug: largestSubmatrixWithRearrangements
Author: Neo
Date: 2026-03-17 12:33:19
"""

import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestSubmatrix(self, matrix: List[List[int]]) -> int:
        height = [0] * len(matrix[0])
        max_area = 0
        for row in matrix:
            q = []
            for j, x in enumerate(row):
                height[j] = 0 if x == 0 else height[j] + 1
                if height[j] > 0:
                    q.append(height[j])
            heapq.heapify(q)
            while q:
                cur_height = heapq.heappop(q)
                max_area = max(max_area, cur_height * (len(q) + 1))

        return max_area


# leetcode submit region end(Prohibit modification and deletion)
