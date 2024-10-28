"""
Title: 684.冗余连接
Title Slug: redundantConnection
Author: Neo
Date: 2024-10-27 12:09:19
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        fa = [i for i in range(n + 1)]
        sz = [1] * (n + 1)

        def find(x):
            if fa[x] != x:
                fa[x] = find(fa[x])
            return fa[x]

        def connect(x, y):
            rx, ry = find(x), find(y)
            if rx == ry:
                return False
            if sz[rx] < sz[ry]:
                rx, ry = ry, rx
            fa[ry] = rx
            sz[rx] += sz[ry]
            return True

        ans = []
        for i, j in edges:
            if not connect(i, j):
                ans = [i, j]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
