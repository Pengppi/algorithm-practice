"""
Title: 2065.最大化一张图中的路径价值
Title Slug: maximumPathQualityOfAGraph
Author: Neo
Date: 2024-07-01 18:19:38
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximalPathQuality(self, values: List[int], edges: List[List[int]], maxTime: int) -> int:
        n = len(values)
        g = [[] for _ in range(n)]
        for x, y, t in edges:
            g[x].append([y, t])
            g[y].append([x, t])
        vis = [False] * n
        ans = 0

        def dfs(x: int, time: int, val: int):
            if x == 0:
                nonlocal ans
                ans = max(ans, val)
            for y, t in g[x]:
                if t + time > maxTime:
                    continue
                if vis[y]:
                    dfs(y, time + t, val)
                else:
                    vis[y] = True
                    dfs(y, time + t, val + values[y])
                    vis[y] = False

        vis[0] = True
        dfs(0, 0, values[0])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
