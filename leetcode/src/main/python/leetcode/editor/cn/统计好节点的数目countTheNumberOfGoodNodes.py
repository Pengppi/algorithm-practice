"""
Title: 3249.统计好节点的数目
Title Slug: countTheNumberOfGoodNodes
Author: Neo
Date: 2024-11-14 12:51:29
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countGoodNodes(self, edges: List[List[int]]) -> int:
        n = len(edges) + 1
        g = [[] for _ in range(n)]
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        def dfs(x: int, fa: int) -> int:
            sz = 1
            st = set()
            for y in g[x]:
                if y == fa:
                    continue
                cnt = dfs(y, x)
                st.add(cnt)
                sz += cnt
            if len(st) < 2:
                nonlocal ans
                ans += 1
            return sz

        ans = 0
        dfs(0, -1)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
