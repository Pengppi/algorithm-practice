"""
Title: 3650.Minimum Cost Path with Edge Reversals
Title Slug: minimumCostPathWithEdgeReversals
Author: Neo
Date: 2026-01-27 09:49:11
"""
from cmath import inf
from heapq import heappush, heappop
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minCost(self, n: int, edges: List[List[int]]) -> int:
        g = [[] for _ in range(n)]

        for x, y, wt in edges:
            g[x].append((y, wt))
            g[y].append((x, wt * 2))

        dis = [inf] * n
        dis[0] = 0
        h = [(0, 0)]
        while h:
            dx, x = heappop(h)
            if dx > dis[x]:
                continue
            if x == n - 1:
                return dx
            for y, wt in g[x]:
                if dis[y] > dis[x] + wt:
                    dis[y] = dis[x] + wt
                    heappush(h, (dis[y], y))
        return -1


# leetcode submit region end(Prohibit modification and deletion)
