"""
Title: 2536.Increment Submatrices by One
Title Slug: incrementSubmatricesByOne
Author: Neo
Date: 2025-11-14 12:47:49
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rangeAddQueries(self, n: int, queries: List[List[int]]) -> List[List[int]]:
        # 二维差分
        diff = [[0] * (n + 2) for _ in range(n + 2)]
        for x1, y1, x2, y2 in queries:
            diff[x1 + 1][y1 + 1] += 1
            diff[x1 + 1][y2 + 2] -= 1
            diff[x2 + 2][y1 + 1] -= 1
            diff[x2 + 2][y2 + 2] += 1
        # 原地计算 diff 的二维前缀和，然后填入答案
        mat = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                diff[i + 1][j + 1] += diff[i + 1][j] + diff[i][j + 1] - diff[i][j]
                mat[i][j] = diff[i + 1][j + 1]
        return mat
# leetcode submit region end(Prohibit modification and deletion)
