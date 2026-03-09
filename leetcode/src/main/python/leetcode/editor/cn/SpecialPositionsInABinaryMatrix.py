"""
Title: 1582.Special Positions in a Binary Matrix
Title Slug: specialPositionsInABinaryMatrix
Author: Neo
Date: 2026-03-04 12:14:37
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0])
        rowCnt = [0] * m
        colCnt = [0] * n
        specialCoordinate = []
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    rowCnt[i] += 1
                    colCnt[j] += 1
                    specialCoordinate.append((i, j))

        return sum(
            [1 for x, y in specialCoordinate if rowCnt[x] == 1 and colCnt[y] == 1]
        )

# leetcode submit region end(Prohibit modification and deletion)
