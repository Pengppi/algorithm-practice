"""
Title: 3142.判断矩阵是否满足条件
Title Slug: checkIfGridSatisfiesConditions
Author: Neo
Date: 2024-08-29 17:15:45
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def satisfiesConditions(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i < m - 1 and grid[i][j] != grid[i + 1][j]:
                    return False
                if j < n - 1 and grid[i][j] == grid[i][j + 1]:
                    return False

        return True

# leetcode submit region end(Prohibit modification and deletion)
