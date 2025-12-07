"""
Title: 2872.Maximum Number of K-Divisible Components
Title Slug: maximumNumberOfKDivisibleComponents
Author: Neo
Date: 2025-11-28 12:34:47
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict
from typing import List


class Solution:

    def maxKDivisibleComponents(self, n: int, edges: List[List[int]],
                                values: List[int], k: int) -> int:
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        ans = 0

        def dfs(x: int, fa: int) -> int:
            total = values[x]
            for y in g[x]:
                if y != fa:
                    total += dfs(y, x)

            nonlocal ans
            ans += total % k == 0
            return total % k

        dfs(0, -1)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
