"""
Title: 743.网络延迟时间
Title Slug: networkDelayTime
Author: Neo
Date: 2024-11-25 12:50:10
"""
import heapq
from cmath import inf
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        g = defaultdict(list)
        for u, v, w in times:
            g[u - 1].append((v - 1, w))
        dis = [inf] * n
        dis[k - 1] = 0
        q = [(0, k - 1)]
        while q:
            w, x = heapq.heappop(q)
            if w > dis[x]:
                continue
            for y, d in g[x]:
                nw = w + d
                if nw < dis[y]:
                    dis[y] = nw
                    q.append((nw, y))
        ans = max(dis)
        return ans if ans < inf else -1

# leetcode submit region end(Prohibit modification and deletion)
