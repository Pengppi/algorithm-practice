"""
Title: 3373.连接两棵树后最大目标节点数目 II
Title Slug: maximizeTheNumberOfTargetNodesAfterConnectingTreesIi
Author: Neo
Date: 2025-05-29 21:49:41
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def count(self, edges: List[List[int]]) -> (List[List[int]], List[int]):
        g = [[] for _ in range(len(edges) + 1)]
        for x, y in edges:
            g[x].append(y)
            g[y].append(x)

        cnt = [0, 0]

        def dfs(x: int, fa: int, flg: int):
            cnt[flg] += 1
            for y in g[x]:
                if y != fa:
                    dfs(y, x, flg ^ 1)

        dfs(0, -1, 0)
        return g, cnt

    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]]) -> List[int]:
        g, cnt1 = self.count(edges1)
        _, cnt2 = self.count(edges2)
        mx2 = max(cnt2)
        ans = [mx2] * (len(edges1) + 1)

        def dfs(x: int, fa: int, flg: int):
            ans[x] += cnt1[flg]
            for y in g[x]:
                if y != fa:
                    dfs(y, x, flg ^ 1)

        dfs(0, -1, 0)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
