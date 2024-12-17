"""
Title: 834.树中距离之和
Title Slug: sumOfDistancesInTree
Author: Neo
Date: 2024-12-08 14:10:30
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        ans = [0] * n
        sz = [0] * n

        def dfs(x, fa, depth):
            ans[0] += depth
            sz[x] = 1
            for y in g[x]:
                if y != fa:
                    dfs(y, x, depth + 1)
                    sz[x] += sz[y]

        def dfs2(x, fa):
            for y in g[x]:
                if y != fa:
                    ans[y] = ans[x] + n - 2 * sz[y]
                    dfs2(y, x)

        dfs(0, -1, 0)
        dfs2(0,-1)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
