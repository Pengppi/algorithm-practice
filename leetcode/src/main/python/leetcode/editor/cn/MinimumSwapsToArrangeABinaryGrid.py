"""
Title: 1536.Minimum Swaps to Arrange a Binary Grid
Title Slug: minimumSwapsToArrangeABinaryGrid
Author: Neo
Date: 2026-03-02 11:02:20
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSwaps(self, grid: List[List[int]]) -> int:
        n = len(grid)

        trailingZero = [n] * n
        for i in range(n):
            for j in range(n - 1, -1, -1):
                if grid[i][j]:
                    trailingZero[i] = n - 1 - j
                    break

        ans = 0
        for i in range(n - 1):
            needZero = n - 1 - i
            for j in range(i, n):
                if trailingZero[j] >= needZero:
                    ans += j - i
                    trailingZero[i + 1 : j + 1] = trailingZero[i:j]
                    break
            else:
                return -1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
