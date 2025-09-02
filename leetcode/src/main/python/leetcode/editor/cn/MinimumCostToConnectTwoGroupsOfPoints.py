"""
Title: 1595.Minimum Cost to Connect Two Groups of Points
Title Slug: minimumCostToConnectTwoGroupsOfPoints
Author: Neo
Date: 2025-08-17 17:16:02
"""
from functools import cache
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def connectTwoGroups(self, cost: List[List[int]]) -> int:
        m, n = len(cost), len(cost[0])
        minCost = list(map(min, zip(*cost)))

        @cache
        def dfs(i, j_mask):
            if i == -1:
                res = 0
                for j in range(n):
                    if j_mask & (1 << j) == 0:
                        res += minCost[j]
            else:
                res = inf
                for j in range(n):
                    res = min(res, cost[i][j] + dfs(i - 1, j_mask | (1 << j)))

            return res

        return dfs(m - 1, 0)


# leetcode submit region end(Prohibit modification and deletion)


Solution().connectTwoGroups([[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]])
