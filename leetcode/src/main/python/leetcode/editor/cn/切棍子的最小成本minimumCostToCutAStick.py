"""
Title: 1547.切棍子的最小成本
Title Slug: minimumCostToCutAStick
Author: Neo
Date: 2024-11-11 12:59:55
"""
from cmath import inf
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        cuts.sort()
        cuts = [0] + cuts + [n]

        @cache
        def dfs(i, j):
            if j == i + 1:
                return 0
            res = inf
            for k in range(i + 1, j):
                res = min(res, dfs(i, k) + dfs(k, j))
            return res + cuts[j] - cuts[i]

        return dfs(0, len(cuts) - 1)

# leetcode submit region end(Prohibit modification and deletion)
