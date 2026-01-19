"""
Title: 1895.Largest Magic Square
Title Slug: largestMagicSquare
Author: Neo
Date: 2026-01-18 10:17:34
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        rs = [[0] * (n + 1) for _ in range(m)]
        cs = [[0] * n for _ in range(m + 1)]
        ds = [[0] * (n + 1) for _ in range(m + 1)]
        rds = [[0] * (n + 1) for _ in range(m + 1)]

        for i, row in enumerate(grid):
            for j, x in enumerate(row):
                rs[i][j + 1] = rs[i][j] + x
                cs[i + 1][j] = cs[i][j] + x
                ds[i + 1][j + 1] = ds[i][j] + x
                rds[i + 1][j] = rds[i][j + 1] + x

        for k in range(min(m, n), 1, -1):
            for i in range(k, m + 1):
                for j in range(k, n + 1):
                    s = ds[i][j] - ds[i - k][j - k]

                    if rds[i][j - k] - rds[i - k][j] != s:
                        continue

                    if any(rs[r][j] - rs[r][j - k] != s for r in range(i - k, i)):
                        continue

                    if any(cs[i][c] - cs[i - k][c] != s for c in range(j - k, j)):
                        continue
                    return k
        return 1


# leetcode submit region end(Prohibit modification and deletion)
