"""
Title: 1878.Get Biggest Three Rhombus Sums in a Grid
Title Slug: getBiggestThreeRhombusSumsInAGrid
Author: Neo
Date: 2026-03-16 12:34:19
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def getBiggestThree(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])

        diag_sum = [[0] * (n + 1) for _ in range(m + 1)]
        anti_sum = [[0] * (n + 1) for _ in range(m + 1)]

        for i, row in enumerate(grid):
            for j, x in enumerate(row):
                diag_sum[i + 1][j + 1] = diag_sum[i][j] + x
                anti_sum[i + 1][j] = anti_sum[i][j + 1] + x

        def query_diagonal(x: int, y: int, k: int) -> int:
            return diag_sum[x + k][y + k] - diag_sum[x][y]

        def query_anti(x: int, y: int, k: int) -> int:
            return anti_sum[x + k][y + 1 - k] - anti_sum[x][y + 1]

        x = y = z = 0

        def update(v: int) -> None:
            nonlocal x, y, z
            if v > x:
                x, y, z = v, x, y
            elif x > v > y:
                y, z = v, y
            elif y > v > z:
                z = v

        for i, row in enumerate(grid):
            for j, v in enumerate(row):
                update(v)
                mx = min(i, m - 1 - i, j, n - 1 - j)

                for k in range(1, mx + 1):
                    a = query_diagonal(i - k, j, k)  # 菱形右上的边
                    b = query_diagonal(i, j - k, k)  # 菱形左下的边
                    c = query_anti(i - k + 1, j - 1, k - 1)  # 菱形左上的边
                    d = query_anti(i, j + k, k + 1)  # 菱形右下的边
                    update(a + b + c + d)

        ans = [x, y, z]

        while ans[-1] == 0:  # 不同的和少于三个
            ans.pop()

        return ans


# leetcode submit region end(Prohibit modification and deletion)
