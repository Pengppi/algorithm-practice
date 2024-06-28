"""
Title: 2742.给墙壁刷油漆
Title Slug: paintingTheWalls
Author: Neo
Date: 2024-06-28 16:03:15
"""
from cmath import inf
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def paintWalls(self, cost: List[int], time: List[int]) -> int:
        n = len(cost)

        @cache
        def dfs(i: int, j: int) -> int:
            if j > i:
                return 0
            if i < 0:
                return inf
            return min(dfs(i - 1, j + time[i]) + cost[i], dfs(i - 1, j - 1))

        return dfs(n - 1, 0)

# leetcode submit region end(Prohibit modification and deletion)
