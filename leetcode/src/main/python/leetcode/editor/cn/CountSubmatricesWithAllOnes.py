"""
Title: 1504.Count Submatrices With All Ones
Title Slug: countSubmatricesWithAllOnes
Author: Neo
Date: 2025-08-21 22:00:19
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numSubmat(self, mat: List[List[int]]) -> int:
        m, n = len(mat), len(mat[0]),
        ans = 0
        for i in range(m):
            for j in range(n):
                if not mat[i][j]:
                    continue
                mx_j = n
                for x in range(i, m):
                    y = j
                    while y < mx_j and mat[x][y]:
                        y += 1
                        ans += 1
                    mx_j = y
        return ans
# leetcode submit region end(Prohibit modification and deletion)
