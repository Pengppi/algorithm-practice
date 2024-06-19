"""
Title: 2713.矩阵中严格递增的单元格数
Title Slug: maximumStrictlyIncreasingCellsInAMatrix
Author: Neo
Date: 2024-06-19 12:20:49
"""
from collections import defaultdict
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxIncreasingCells(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        map = defaultdict(list)
        for i in range(m):
            for j in range(n):
                map[mat[i][j]].append((i, j))
        rows = [0] * m
        cols = [0] * n
        for val, pos in sorted(map.items(), key=lambda x: x[0]):
            old_mx = [max(rows[i], cols[j]) for i, j in pos]
            for i, (x, y) in enumerate(pos):
                rows[x] = max(rows[x], old_mx[i] + 1)
                cols[y] = max(cols[y], old_mx[i] + 1)

        return max(rows)

    # leetcode submit region end(Prohibit modification and deletion)
