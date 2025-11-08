"""
Title: 3607.Power Grid Maintenance
Title Slug: powerGridMaintenance
Author: Neo
Date: 2025-11-06 12:28:56
"""
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def processQueries(self, c: int, connections: List[List[int]], queries: List[List[int]]) -> List[int]:
        fa = [i for i in range(c)]
        kids = defaultdict(SortedList)
        for i in range(c):
            kids[i].add(i)

        def find(x: int) -> int:
            if x == fa[x]:
                return x
            else:
                fa[x] = find(fa[x])
                return fa[x]

        def unite(x: int, y: int) -> None:
            px = find(x)
            py = find(y)
            if px == py:
                return
            if len(kids[py]) < len(kids[px]):
                fa[py] = px
                kids[px].update(kids[py])
                del kids[py]
            else:
                fa[px] = py
                kids[py].update(kids[px])
                del kids[px]

        for u, v in connections:
            unite(u - 1, v - 1)

        ans = []

        for t, x in queries:
            x = x - 1
            px = find(x)
            if t == 2 :
                if x in kids[px]:
                    kids[px].remove(x)
                continue
            if x in kids[px]:
                ans.append(x + 1)
            else:
                ans.append(kids[px][0] + 1 if kids[px] else -1)
        return ans
        # leetcode submit region end(Prohibit modification and deletion)


Solution().processQueries(5, [[1, 2], [2, 3], [3, 4], [4, 5]], [[1, 3], [2, 1], [1, 1], [2, 2], [1, 2]])
