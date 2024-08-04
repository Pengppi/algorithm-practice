import heapq
from cmath import inf
from collections import defaultdict
from typing import List


class neighborSum:

    def __init__(self, grid: List[List[int]]):
        n = len(grid)
        self.g = grid
        self.n = n
        mp = {}
        for i, row in enumerate(grid):
            for j, num in enumerate(row):
                mp[num] = (i, j)
        self.mp = mp

    def adjacentSum(self, value: int) -> int:
        x, y = self.mp[value]
        dirs = [0, -1, 0, 1, 0]
        res = 0
        for k in range(4):
            nx = x + dirs[k]
            ny = y + dirs[k + 1]
            if 0 <= nx < self.n and 0 <= ny < self.n:
                res += self.g[nx][ny]
        return res

    def diagonalSum(self, value: int) -> int:
        x, y = self.mp[value]
        dirs = [-1, -1, 1, 1, -1]
        res = 0
        for k in range(4):
            nx = x + dirs[k]
            ny = y + dirs[k + 1]
            if 0 <= nx < self.n and 0 <= ny < self.n:
                res += self.g[nx][ny]
        return res


class Solution:
    def shortestDistanceAfterQueries2(self, n: int, queries: List[List[int]]) -> List[int]:
        def dijkstra(e, s):
            dis = defaultdict(lambda: float("inf"))
            dis[s] = 0
            q = [(0, s)]
            vis = set()
            while q:
                _, u = heapq.heappop(q)
                if u in vis:
                    continue
                vis.add(u)
                for v, w in e[u]:
                    if dis[v] > dis[u] + w:
                        dis[v] = dis[u] + w
                        heapq.heappush(q, (dis[v], v))
            return dis

        e = [[] for _ in range(n)]
        for i in range(n - 1):
            e[i].append([i + 1, 1])

        ans = []
        for u, v in queries:
            e[u].append([v, 1])
            ans.append(dijkstra(e, 0)[n - 1])
        return ans

class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        def dijkstra(e, s):
            dis = defaultdict(lambda: float("inf"))
            dis[s] = 0
            q = [(0, s)]
            vis = set()
            while q and dis[n - 1] == inf:
                _, u = heapq.heappop(q)
                if u in vis:
                    continue
                vis.add(u)
                for v, w in e[u]:
                    if dis[v] > dis[u] + w:
                        dis[v] = dis[u] + w
                        if v == n - 1:
                            return dis[v]
                        heapq.heappush(q, (dis[v], v))
            return dis[n - 1]

        e = [[] for _ in range(n)]
        for i in range(n - 1):
            e[i].append([i + 1, 1])

        ans = []
        for u, v in queries:
            e[u].append([v, 1])
            ans.append(dijkstra(e, 0))
        return ans
