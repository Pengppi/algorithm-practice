"""
Title: 1970.Last Day Where You Can Still Cross
Title Slug: lastDayWhereYouCanStillCross
Author: Neo
Date: 2025-12-31 16:23:58
"""

# leetcode submit region begin(Prohibit modification and deletion)
from bisect import bisect_right
from collections import defaultdict, deque
from math import inf
from typing import List


class Solution:

    def latestDayToCross(self, row: int, col: int,
                         cells: List[List[int]]) -> int:

        mp = defaultdict(lambda: inf)
        for v, (r, c) in enumerate(cells, 1):
            mp[(r - 1, c - 1)] = v

        dirs = [0, 1, 0, -1, 0]

        def bfsCheck(day: int) -> bool:
            q = deque()
            vis = set()
            for i in range(col):
                if mp[(0, i)] > day:
                    q.append((0, i))
                    vis.add((0, i))
            while q:
                x, y = q.popleft()
                for k in range(4):
                    nx, ny = x + dirs[k], y + dirs[k + 1]
                    if 0 > nx or nx >= row or 0 > ny or ny >= col or mp[(
                            nx, ny)] <= day or (nx, ny) in vis:
                        continue
                    if nx == row - 1:
                        return True
                    vis.add((nx, ny))
                    q.append((nx, ny))
            return False

        left, right = 0, len(cells)
        while left < right:
            mid = (left + right + 1) // 2
            if bfsCheck(mid):
                left = mid
            else:
                right = mid - 1
        return left


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().latestDayToCross(2, 2, [[1, 1], [2, 1], [1, 2], [2, 2]]))
