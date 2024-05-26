"""
Title: 1572.矩阵对角线元素的和
Title Slug: matrixDiagonalSum
Author: Neo
Date: 2024-05-26 13:58:12
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def diagonalSum(self, mat: List[List[int]]) -> int:
        n = len(mat)
        i, j, ans = 0, 0, 0
        while i < n and j < n:
            ans += mat[i][j]
            i += 1
            j += 1
        i, j = 0, n - 1
        while i < n and j >= 0:
            ans += mat[i][j]
            i += 1
            j -= 1
        if n & 1:
            ans -= mat[n // 2][n // 2]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
