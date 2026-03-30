"""
Title: 2906.Construct Product Matrix
Title Slug: constructProductMatrix
Author: Neo
Date: 2026-03-24 12:14:03
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        mod = 12345
        m, n = len(grid), len(grid[0])
        suffix = [[1] * n for _ in range(m)]
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                cur = suffix[i][j] * grid[i][j] % mod
                if j > 0:
                    suffix[i][j - 1] = cur
                elif i > 0:
                    suffix[i - 1][n - 1] = cur

        prefix = 1
        for i in range(m):
            for j in range(n):
                cur = prefix * suffix[i][j] % mod
                prefix = prefix * grid[i][j] % mod
                grid[i][j] = cur

        return grid


# leetcode submit region end(Prohibit modification and deletion)
Solution().constructProductMatrix([[1, 2], [3, 4]])
