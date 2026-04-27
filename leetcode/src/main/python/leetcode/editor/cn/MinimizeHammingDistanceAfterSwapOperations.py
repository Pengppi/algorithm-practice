"""
Title: 1722.Minimize Hamming Distance After Swap Operations
Title Slug: minimizeHammingDistanceAfterSwapOperations
Author: Neo
Date: 2026-04-21 11:03:56
"""

from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumHammingDistance(
        self, source: List[int], target: List[int], allowedSwaps: List[List[int]]
    ) -> int:
        g = defaultdict(list)
        for u, v in allowedSwaps:
            g[u].append(v)
            g[v].append(u)

        n = len(source)
        vis = [False] * n

        def dfs(x, diff) -> None:
            vis[x] = True
            diff[source[x]] += 1
            diff[target[x]] -= 1
            for y in g[x]:
                if not vis[y]:
                    dfs(y, diff)

        ans = 0
        for i in range(n):
            if not vis[i]:
                diff = defaultdict(int)
                dfs(i, diff)
                ans += sum(abs(v) for v in diff.values())

        return ans // 2


# leetcode submit region end(Prohibit modification and deletion)
