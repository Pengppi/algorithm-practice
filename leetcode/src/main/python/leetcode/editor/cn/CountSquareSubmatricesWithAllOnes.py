"""
Title: 1277.Count Square Submatrices with All Ones
Title Slug: countSquareSubmatricesWithAllOnes
Author: Neo
Date: 2025-08-20 12:32:54
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])

        @cache
        def dfs(x, y):
            if x < 0 or y < 0 or matrix[x][y] == 0:
                return 0

            return min(dfs(x - 1, y), dfs(x, y - 1), dfs(x - 1, y - 1)) + 1

        return sum(dfs(i, j) for i in range(m) for j in range(n))

# leetcode submit region end(Prohibit modification and deletion)
