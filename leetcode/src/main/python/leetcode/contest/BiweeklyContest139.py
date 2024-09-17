import heapq
from asyncio import as_completed
from collections import deque
from concurrent.futures import ThreadPoolExecutor
from itertools import combinations
from typing import List


class Solution:
    def stableMountains(self, height: List[int], threshold: int) -> List[int]:
        ans = []
        for i in range(1, len(height)):
            if height[i - 1] > threshold:
                ans.append(i)
        return ans

    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        m = len(grid)
        n = len(grid[0])
        vis = [[False] * n for _ in range(m)]
        q = [(grid[0][0], 0, 0)]
        vis[0][0] = True
        while q:
            s, x, y = heapq.heappop(q)
            if s >= health:
                return False
            if x == m - 1 and y == n - 1:
                return True
            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                new_x, new_y = x + dx, y + dy
                if 0 <= new_x < m and 0 <= new_y < n and not vis[new_x][new_y]:
                    new_s = s + grid[new_x][new_y]
                    if new_s < health:
                        vis[new_x][new_y] = True
                        heapq.heappush(q, (new_s, new_x, new_y))
        return False

    def maxValue(self, nums: List[int], k: int) -> int:
        nums.sort(reverse=True)
        l, r = 0, 0
        ans = 0
        j = 0
        for i in range(len(nums)):
            if i < k:
                l |= nums[i]
            else:
                j += 1
                r |= nums[i]
                if j == k:
                    ans = max(ans, l ^ r)
                    j = 0
        return ans
