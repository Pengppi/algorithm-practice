"""
Title: 3546.Equal Sum Grid Partition I
Title Slug: equalSumGridPartitionI
Author: Neo
Date: 2026-03-25 09:27:52
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        pre_sum = [[0] * (n + 1) for _ in range(m + 1)]
        for i, row in enumerate(grid):
            for j, x in enumerate(row):
                pre_sum[i + 1][j + 1] = (
                    pre_sum[i + 1][j] + pre_sum[i][j + 1] - pre_sum[i][j] + x
                )
        tot = pre_sum[m][n]
        if tot & 1:
            return False
        target = tot // 2
        for i in range(1, m):
            if pre_sum[i][n] == target:
                return True
            elif pre_sum[i][n] > target:
                break
        for j in range(1, n):
            if pre_sum[m][j] == target:
                return True
            elif pre_sum[m][j] > target:
                break
        return False


# leetcode submit region end(Prohibit modification and deletion)
