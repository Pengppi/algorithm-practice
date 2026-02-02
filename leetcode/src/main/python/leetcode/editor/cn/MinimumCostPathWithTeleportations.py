"""
Title: 3651.Minimum Cost Path with Teleportations
Title Slug: minimumCostPathWithTeleportations
Author: Neo
Date: 2026-01-28 09:51:49
"""

from functools import cache
from math import inf
from typing import List

from sortedcontainers.sorteddict import SortedDict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minCost(self, grid: List[List[int]], k: int) -> int:
        n = len(grid[0])
        mx = max(map(max, grid))

        suf_min_f = [inf] * (mx + 2)
        for _ in range(k + 1):
            min_f = [inf] * (mx + 1)

            f = [inf] * (n + 1)
            f[1] = -grid[0][0]
            for row in grid:
                for j, x in enumerate(row):
                    f[j + 1] = min(min(f[j], f[j + 1]) + x, suf_min_f[x])
                    min_f[x] = min(min_f[x], f[j + 1])

            for i in range(mx, -1, -1):
                suf_min_f[i] = min(suf_min_f[i + 1], min_f[i])

        return f[n]


# leetcode submit region end(Prohibit modification and deletion)
