"""
Title: 3112.访问消失节点的最少时间
Title Slug: minimumTimeToVisitDisappearingNodes
Author: Neo
Date: 2024-07-18 13:49:31
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTime(self, n: int, edges: List[List[int]], disappear: List[int]) -> List[int]:
        g = [[] for _ in range(n)]
        for u, v, w in edges:
            g[u].append((v, w))
            g[v].append((u, w))

        dis = [-1] * n
        dis[0] = 0
        q = [(0, 0)]
        while q:
            dx, x = heapq.heappop(q)
            if dx > dis[x]:
                continue
            for y, w in g[x]:
                dy = w + dx
                if dy < disappear[y] and (dis[y] == -1 or dy < dis[y]):
                    dis[y] = dy
                    heapq.heappush(q, (dy, y))
        return dis


# leetcode submit region end(Prohibit modification and deletion)

Solution().minimumTime(3, [[0, 1, 2], [1, 2, 1], [0, 2, 4]], [1, 1, 5])
