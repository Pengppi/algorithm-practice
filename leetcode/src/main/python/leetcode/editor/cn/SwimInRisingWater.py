"""
Title: 778.Swim in Rising Water
Title Slug: swimInRisingWater
Author: Neo
Date: 2025-10-06 10:22:29
"""
import bisect
from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        if m == 1 and n == 1:
            return 0
        dirs = [1, 0, -1, 0, 1]

        def check(t: int) -> bool:
            if grid[m - 1][n - 1] > t:
                return False

            vis = set()
            q = deque()
            vis.add((m - 1, n - 1))
            q.append((m - 1, n - 1))
            while q:
                sz = len(q)
                for _ in range(sz):
                    x, y = q.popleft()

                    for k in range(4):
                        nx, ny = x + dirs[k], y + dirs[k + 1]
                        if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] <= t and (nx, ny) not in vis:
                            if nx == 0 and ny == 0:
                                return True
                            vis.add((nx, ny))
                            q.append((nx, ny))

            return False

        mx = n * n
        return bisect.bisect_left(range(mx), x=True, key=lambda x: check(x))

# leetcode submit region end(Prohibit modification and deletion)
