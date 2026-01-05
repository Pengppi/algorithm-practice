"""
Title: 840.Magic Squares In Grid
Title Slug: magicSquaresInGrid
Author: Neo
Date: 2025-12-30 20:47:06
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        if m < 3 or n < 3:
            return 0
        ans = 0

        def isMagicSquare(x: int, y: int) -> bool:
            if grid[x - 1][y - 1] + grid[x + 1][y + 1] != grid[x + 1][
                y - 1] + grid[x - 1][y + 1]:
                return False
            mask = 0
            cols = [0] * 3
            rows = [0] * 3
            for i in range(3):
                for j in range(3):
                    d = grid[x + i - 1][y + j - 1]
                    cols[i] += d
                    rows[j] += d
                    mask |= 1 << d
            return mask == 0b1111111110 and cols[0] == cols[2] == rows[
                0] == rows[2] == 15

        for i in range(1, m - 1):
            for j in range(1, n - 1):
                if grid[i][j] == 5 and isMagicSquare(i, j):
                    ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
