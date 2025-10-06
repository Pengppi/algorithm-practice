"""
Title: 1039.Minimum Score Triangulation of Polygon
Title Slug: minimumScoreTriangulationOfPolygon
Author: Neo
Date: 2025-09-29 12:41:45
"""
from cmath import inf
from functools import lru_cache, cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minScoreTriangulation(self, values: List[int]) -> int:
        n = len(values)

        @lru_cache(maxsize=n * n)
        def dfs(i, j):
            if i + 1 == j:
                return 0
            res = inf
            v = values[i] * values[j]
            for k in range(i + 1, j):
                res = min(res, (dfs(i, k) + dfs(k, j)) + v * values[k])
            return res

        return dfs(0, n - 1)
# leetcode submit region end(Prohibit modification and deletion)
