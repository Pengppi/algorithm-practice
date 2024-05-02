"""
Title: 73.矩阵置零
Title Slug: setMatrixZeroes
Author: Neo
Date: 2024-05-02 21:33:50
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        m = len(matrix)
        n = len(matrix[0])
        flg_col = False
        for i in range(m):
            if matrix[i][0] == 0:
                flg_col = True
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = matrix[0][j] = 0
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, 0, -1):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
            if flg_col:
                matrix[i][0] = 0
# leetcode submit region end(Prohibit modification and deletion)
