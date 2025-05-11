"""
Title: 3342.到达最后一个房间的最少时间 II
Title Slug: findMinimumTimeToReachLastRoomIi
Author: Neo
Date: 2025-05-08 18:31:47
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        m, n = len(moveTime), len(moveTime[0])
        dirs = [0, -1, 0, 1, 0]
        q = list()
        q.append((0, 0, 0, 1))
        vis = [[False for _ in range(n)] for _ in range(m)]
        while q:
            t, x, y, f = heapq.heappop(q)
            if vis[x][y]:
                continue
            if x == m - 1 and y == n - 1:
                return t
            nf = 2 if f == 1 else 1
            vis[x][y] = True
            for i in range(4):
                nx, ny = x + dirs[i], y + dirs[i + 1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n or vis[nx][ny]:
                    continue
                heapq.heappush(q, (max(t, moveTime[nx][ny]) + f, nx, ny, nf))
        return -1

# leetcode submit region end(Prohibit modification and deletion)
