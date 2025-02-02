"""
Title: 119.杨辉三角 II
Title Slug: pascalsTriangleIi
Author: Neo
Date: 2025-01-28 13:02:47
"""
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
mx = 34
rows = [[1] * (i + 1) for i in range(mx)]
for i in range(2, mx):
    for j in range(1, i):
        rows[i][j] = rows[i - 1][j - 1] + rows[i - 1][j]


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        return rows[rowIndex]

# leetcode submit region end(Prohibit modification and deletion)
