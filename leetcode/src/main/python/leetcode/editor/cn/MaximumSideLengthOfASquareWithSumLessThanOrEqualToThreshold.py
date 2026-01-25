"""
Title: 1292.Maximum Side Length of a Square with Sum Less than or Equal to Threshold
Title Slug: maximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold
Author: Neo
Date: 2026-01-19 12:41:01
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def maxSideLength(self, mat: List[List[int]], threshold: int) -> int:
        m, n = len(mat), len(mat[0])
        ps = [[0] * (n + 1) for _ in range(m + 1)]

        for i, row in enumerate(mat):
            for j, x in enumerate(row):
                ps[i + 1][j + 1] = ps[i + 1][j] + ps[i][j + 1] - ps[i][j] + x

        def query(x1: int, y1: int, x2: int, y2: int) -> int:
            return ps[x2 + 1][y2 + 1] - ps[x1][y2 + 1] - ps[x2 + 1][y1] + ps[x1][y1]

        ans = 0
        for i in range(m):
            for j in range(n):
                while (
                    i + ans < m
                    and j + ans < n
                    and query(i, j, i + ans, j + ans) <= threshold
                ):
                    ans += 1

        return ans


# leetcode submit region end(Prohibit modification and deletion)
