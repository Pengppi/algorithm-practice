"""
Title: 1289.下降路径最小和  II
Title Slug: minimumFallingPathSumIi
Author: Neo
Date: 2024-05-26 14:04:34
"""
from functools import cache
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)

        @cache
        def dfs(i: int, j: int) -> int:
            if i == n:
                return 0
            res = inf
            for y, num in enumerate(grid[i]):
                if y != j:
                    res = min(res, num + dfs(i + 1, y))
            return res

        return dfs(0, -1)
# leetcode submit region end(Prohibit modification and deletion)
