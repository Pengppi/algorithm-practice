"""
Title: 2959.关闭分部的可行集合数目
Title Slug: numberOfPossibleSetsOfClosingBranches
Author: Neo
Date: 2024-07-17 12:24:50
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfSets(self, n: int, maxDistance: int, roads: List[List[int]]) -> int:
        g = [[inf] * n for _ in range(n)]
        for u, v, w in roads:
            g[u][v] = min(g[u][v], w)
            g[v][u] = min(g[v][u], w)

        f = [0] * n

        def isValid(s: int) -> int:
            for i in range(n):
                if (s >> i) & 1:
                    f[i] = g[i].copy()

            for k in range(n):
                if (s >> k & 1) == 0:
                    continue
                for i in range(n):
                    if (s >> i & 1) == 0 or f[i][k] == inf:
                        continue
                    for j in range(n):
                        f[i][j] = min(f[i][j], f[i][k] + f[k][j])

            for i, fi in enumerate(f):
                if (s >> i & 1) == 0:
                    continue
                for j, fij in enumerate(fi[:i]):
                    if (s >> j & 1) and fij > maxDistance:
                        return 0
            return 1

        return sum(isValid(s) for s in range(1 << n))

# leetcode submit region end(Prohibit modification and deletion)
