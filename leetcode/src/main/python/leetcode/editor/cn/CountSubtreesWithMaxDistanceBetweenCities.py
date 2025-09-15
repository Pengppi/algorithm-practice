"""
Title: 1617.Count Subtrees With Max Distance Between Cities
Title Slug: countSubtreesWithMaxDistanceBetweenCities
Author: Neo
Date: 2025-09-13 10:18:30
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubgraphsForEachDiameter(self, n: int, edges: List[List[int]]) -> List[int]:
        g = [[] for _ in range(n + 1)]
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        @cache
        def dfs(x: int, fa: int, dist: int) -> set[int]:
            cur = 1 << x
            if dist == 0:
                return {cur}
            res = set()
            for y in g[x]:
                if y == fa:
                    continue
                res |= dfs(y, x, dist - 1)

            return {s | cur for s in res}

        result = []
        for d in range(1, n):
            total_sets = set()
            for x in range(1, n + 1):
                sets = dfs(x, 0, d)
                total_sets |= sets
            result.append(len(total_sets))
        return result


# leetcode submit region end(Prohibit modification and deletion)
Solution().countSubgraphsForEachDiameter(4, [[1, 2], [2, 3], [2, 4]])
