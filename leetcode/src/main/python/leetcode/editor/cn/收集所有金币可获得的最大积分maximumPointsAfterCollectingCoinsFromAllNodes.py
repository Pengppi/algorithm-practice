"""
Title: 2920.收集所有金币可获得的最大积分
Title Slug: maximumPointsAfterCollectingCoinsFromAllNodes
Author: Neo
Date: 2025-01-23 12:41:25
"""
from collections import defaultdict
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumPoints(self, edges: List[List[int]], coins: List[int], k: int) -> int:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        @cache
        def dfs(i, cnt, fa):
            res1 = (coins[i] >> cnt) - k
            res2 = coins[i] >> (cnt + 1)
            for j in g[i]:
                if j == fa:
                    continue
                res1 += dfs(j, cnt, i)
                if cnt < 13:
                    res2 += dfs(j, cnt + 1, i)
            return max(res1, res2)

        return dfs(0, 0, -1)
# leetcode submit region end(Prohibit modification and deletion)
