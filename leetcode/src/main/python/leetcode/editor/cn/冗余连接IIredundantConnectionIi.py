"""
Title: 685.冗余连接 II
Title Slug: redundantConnectionIi
Author: Neo
Date: 2024-10-28 13:29:16
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        fa = list(range(n + 1))
        pa = list(range(n + 1))

        def find(x):
            if fa[x] != x:
                fa[x] = find(fa[x])
            return fa[x]

        def connect(x, y):
            rx, ry = find(x), find(y)
            if rx == ry:
                return False
            fa[ry] = rx
            return True

        conflict = -1
        circle = -1
        for i, (u, v) in enumerate(edges):
            if pa[v] != v:
                conflict = i
            else:
                pa[v] = u
                if not connect(u, v):
                    circle = i
        if conflict < 0:
            return edges[circle]
        else:
            e = edges[conflict]
            if circle != -1:
                return [pa[e[1]], e[1]]
            else:
                return edges[conflict]

# leetcode submit region end(Prohibit modification and deletion)
