"""
Title: 1605.Find Valid Matrix Given Row and Column Sums
Title Slug: findValidMatrixGivenRowAndColumnSums
Author: Neo
Date: 2025-07-31 14:36:57
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def restoreMatrix(self, rowSum: List[int], colSum: List[int]) -> List[List[int]]:
        m, n = len(rowSum), len(colSum)
        ans = [[0] * n for _ in range(m)]
        i = j = 0
        while i < m and j < n:
            rs, cs = rowSum[i], colSum[j]
            if rs <= cs:
                ans[i][j] = rs
                i += 1
                colSum[j] -= rs
            else:
                ans[i][j] = cs
                j += 1
                rowSum[i] -= cs

        return ans

# leetcode submit region end(Prohibit modification and deletion)
