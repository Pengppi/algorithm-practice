"""
Title: 1129.Shortest Path with Alternating Colors
Title Slug: shortestPathWithAlternatingColors
Author: Neo
Date: 2026-04-12 12:34:14
"""

from collections import defaultdict, deque
from typing import DefaultDict, List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def shortestAlternatingPaths(
            self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]
    ) -> List[int]:
        g: list[DefaultDict[int, list[int]]] = [defaultdict(list) for _ in range(2)]
        for u, v in redEdges:
            g[0][u].append(v)
        for u, v in blueEdges:
            g[1][u].append(v)

        q: deque[tuple[int, int]] = deque()
        q.append((0, 0))
        q.append((1, 0))
        vis = set()
        ans = [-1] * n
        step = 1
        ans[0] = 0
        while q:
            sz = len(q)
            for _ in range(sz):
                flg, x = q.popleft()
                nflg = flg ^ 1
                for nxt in g[flg][x]:
                    if (nflg, nxt) in vis:
                        continue
                    vis.add((nflg, nxt))
                    if ans[nxt] == -1:
                        ans[nxt] = step
                    q.append((nflg, nxt))
            step += 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
