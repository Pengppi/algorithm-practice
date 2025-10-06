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
            g[u - 1].append(v - 1)
            g[v - 1].append(u - 1)

        ans = [0] * (n - 1)

        for mask in range(3, 1 << n):
            if (mask & (mask - 1)) == 0:
                continue

            vis = 0
            diameter = 0

            def dfs(x: int):
                nonlocal vis, diameter
                vis |= 1 << x
                mx_len = 0

                for y in g[x]:
                    yy = 1 << y
                    if (vis & yy) != 0 or (mask & yy) == 0:
                        continue
                    cur_len = dfs(y) + 1
                    diameter = max(diameter, mx_len + cur_len)
                    mx_len = max(mx_len, cur_len)

                return mx_len

            dfs(mask.bit_length() - 1)
            if vis == mask:
                ans[diameter - 1] += 1

        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().countSubgraphsForEachDiameter(4, [[1, 2], [2, 3], [2, 4]])
