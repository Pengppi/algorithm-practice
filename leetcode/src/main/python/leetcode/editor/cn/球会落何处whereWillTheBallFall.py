"""
Title: 1706.球会落何处
Title Slug: whereWillTheBallFall
Author: Neo
Date: 2025-02-15 17:31:16
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])

        @cache
        def dfs(x, y):
            if x == m:
                return y
            neighbor = y + grid[x][y]
            if neighbor < 0 or neighbor == n or grid[x][neighbor] != grid[x][y]:
                return -1
            return dfs(x + 1, neighbor)

        return [dfs(0, i) for i in range(n)]
# leetcode submit region end(Prohibit modification and deletion)
