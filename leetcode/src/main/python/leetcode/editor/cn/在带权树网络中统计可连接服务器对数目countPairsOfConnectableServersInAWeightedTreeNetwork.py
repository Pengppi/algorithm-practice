"""
Title: 3067.在带权树网络中统计可连接服务器对数目
Title Slug: countPairsOfConnectableServersInAWeightedTreeNetwork
Author: Neo
Date: 2024-06-04 22:47:04
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPairsOfConnectableServers(self, edges: List[List[int]], signalSpeed: int) -> List[int]:
        n = len(edges) + 1
        g = [[] for _ in range(n)]
        for a, b, w in edges:
            g[a].append((b, w))
            g[b].append((a, w))

        def dfs(x: int, fa: int, dist: int) -> int:
            cnt = 0 if dist % signalSpeed else 1
            for y, w in g[x]:
                if y != fa:
                    cnt += dfs(y, x, dist + w)
            return cnt

        ans = [0] * n
        for i, gx in enumerate(g):
            if len(gx) == 1:
                continue
            s = 0
            for y, w in gx:
                cnt = dfs(y, i, w)
                ans[i] += cnt * s
                s += cnt

        return ans

# leetcode submit region end(Prohibit modification and deletion)
