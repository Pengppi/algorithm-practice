"""
Title: 3341.到达最后一个房间的最少时间 I
Title Slug: findMinimumTimeToReachLastRoomI
Author: Neo
Date: 2025-05-07 12:16:55
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        m, n = len(moveTime), len(moveTime[0])
        dirs = [0, -1, 0, 1, 0]
        q = list()
        q.append((0, 0, 0))
        vis = [[False for _ in range(n)] for _ in range(m)]
        while q:
            t, x, y = heapq.heappop(q)
            if vis[x][y]:
                continue
            if x == m - 1 and y == n - 1:
                return t
            vis[x][y] = True
            for i in range(4):
                nx, ny = x + dirs[i], y + dirs[i + 1]
                if nx < 0 or nx >= m or ny < 0 or ny >= n or vis[nx][ny]:
                    continue
                heapq.heappush(q, (max(t, moveTime[nx][ny]) + 1, nx, ny))
        return -1
# leetcode submit region end(Prohibit modification and deletion)
