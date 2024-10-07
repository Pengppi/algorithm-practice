"""
Title: 1928.规定时间内到达终点的最小花费
Title Slug: minimumCostToReachDestinationInTime
Author: Neo
Date: 2024-10-03 16:04:58
"""
import heapq
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCost(self, maxTime: int, edges: List[List[int]], passingFees: List[int]) -> int:
        n = len(passingFees)
        g = [[] for _ in range(n)]
        for u, v, t in edges:
            g[u].append((v, t))
            g[v].append((u, t))

        dis = [[inf] * (maxTime + 1) for _ in range(n)]
        dis[0][0] = passingFees[0]
        q = [(dis[0][0], 0, 0)]

        while q:
            dx, x, t = heapq.heappop(q)
            if dx > dis[x][t]:
                continue
            for y, w in g[x]:
                dy = dx + passingFees[y]
                nt = t + w
                if nt <= maxTime and dy < dis[y][nt]:
                    dis[y][nt] = dy
                    heapq.heappush(q, (dy, y, nt))
        ans = min(dis[-1])
        return ans if ans != inf else -1
# leetcode submit region end(Prohibit modification and deletion)
