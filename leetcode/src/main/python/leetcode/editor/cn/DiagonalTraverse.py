"""
Title: 498.Diagonal Traverse
Title Slug: diagonalTraverse
Author: Neo
Date: 2025-08-25 12:37:04
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        m, n = len(mat), len(mat[0])
        ans = [0] * (m * n)
        i = j = 0
        to_top = True
        for k in range(m * n):
            ans[k] = mat[i][j]
            if to_top:
                if i == 0 or j == n - 1:
                    to_top = False
                    if j == n - 1:
                        i += 1
                    elif i == 0:
                        j += 1
                else:
                    i -= 1
                    j += 1
            else:
                if i == m - 1 or j == 0:
                    to_top = True
                    if i == m - 1:
                        j += 1
                    elif j == 0:
                        i += 1
                else:
                    i += 1
                    j -= 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
