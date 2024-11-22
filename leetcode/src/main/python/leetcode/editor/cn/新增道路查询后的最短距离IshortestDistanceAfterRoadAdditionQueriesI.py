"""
Title: 3243.新增道路查询后的最短距离 I
Title Slug: shortestDistanceAfterRoadAdditionQueriesI
Author: Neo
Date: 2024-11-19 12:53:02
"""
from itertools import count
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        e = [[i + 1] for i in range(n - 1)]
        vis = [-1] * (n - 1)

        def bfs(i: int) -> int:
            q = [0]
            for step in count(1):
                tmp = q
                q = []
                for x in tmp:
                    for y in e[x]:
                        if y == n - 1:
                            return step
                        if vis[y] != i:
                            vis[y] = i
                            q.append(y)
            return -1

        ans = []
        for u, v in queries:
            e[u].append(v)
            ans.append(bfs(len(ans)))
        return ans

# leetcode submit region end(Prohibit modification and deletion)
