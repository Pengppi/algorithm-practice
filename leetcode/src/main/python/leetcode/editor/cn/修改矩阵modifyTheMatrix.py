"""
Title: 3033.修改矩阵
Title Slug: modifyTheMatrix
Author: Neo
Date: 2024-07-05 09:29:34
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def modifiedMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        n, m = len(matrix), len(matrix[0])
        for j in range(m):
            mx = -1
            pos = []
            for i in range(n):
                if matrix[i][j] == -1:
                    pos.append(i)
                    continue
                mx = max(mx, matrix[i][j])
            for i in pos:
                matrix[i][j] = mx
        return matrix
# leetcode submit region end(Prohibit modification and deletion)
