"""
Title: 3446.Sort Matrix by Diagonals
Title Slug: sortMatrixByDiagonals
Author: Neo
Date: 2025-08-28 11:20:40
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        n = len(grid)

        def get_diag_nums(x, y):
            length = min(n - x, n - y)
            p = [0] * length
            z = 0
            while z < length:
                p[z] = grid[x][y]
                x += 1
                y += 1
                z += 1
            return p

        def set_diag_nums(x, y, nums):
            for num in nums:
                grid[x][y] = num
                x += 1
                y += 1

        for i in range(n):
            nums = get_diag_nums(i, 0)
            nums.sort(reverse=True)
            set_diag_nums(i, 0, nums)

        for j in range(1, n):
            nums = get_diag_nums(0, j)
            nums.sort()
            set_diag_nums(0, j, nums)
        return grid

# leetcode submit region end(Prohibit modification and deletion)
