"""
Title: 3600.Maximize Spanning Tree Stability with Upgrades
Title Slug: maximizeSpanningTreeStabilityWithUpgrades
Author: Neo
Date: 2026-03-12 12:31:16
"""

from math import inf
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)


class UnionFind:
    def __init__(self, n: int):
        self.fa = [x for x in range(n)]
        self.count = n

    def find(self, x: int) -> int:
        if x == self.fa[x]:
            return x
        else:
            self.fa[x] = self.find(self.fa[x])
            return self.fa[x]

    def connect(self, x: int, y: int) -> bool:
        rx, ry = self.find(x), self.find(y)
        if rx == ry:
            return False
        self.fa[rx] = ry
        self.count -= 1
        return True


class Solution:
    def maxStability(self, n: int, edges: List[List[int]], k: int) -> int:
        must_uf = UnionFind(n)
        all_uf = UnionFind(n)
        mn_s, mx_s = 10**8, 0

        for u, v, s, m in edges:
            if m and not must_uf.connect(u, v):
                return -1
            all_uf.connect(u, v)
            mn_s = min(mn_s, s)
            mx_s = max(mx_s, s)

        if all_uf.count != 1:
            return -1

        def check(low: int) -> bool:
            uf = UnionFind(n)
            for u, v, s, must in edges:
                if must and s < low:
                    return False
                if must or s >= low:
                    uf.connect(u, v)

            left_k = k
            for u, v, s, must in edges:
                if left_k == 0 or uf.count == 1:
                    break
                if not must and s < low <= s * 2 and uf.connect(u, v):
                    left_k -= 1

            return uf.count == 1

        left, right = mn_s, mx_s * 2 + 1

        while left + 1 < right:
            mid = left + (right - left) // 2
            if check(mid):
                left = mid
            else:
                right = mid
        return left


# leetcode submit region end(Prohibit modification and deletion)
