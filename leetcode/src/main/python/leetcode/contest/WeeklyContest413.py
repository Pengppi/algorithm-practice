import heapq
from functools import lru_cache
from linecache import cache
from typing import List


class Solution:
    def checkTwoChessboards(self, coordinate1: str, coordinate2: str) -> bool:
        columns = "abcdefgh"
        row1, col1 = int(coordinate1[1]) - 1, columns.index(coordinate1[0])
        row2, col2 = int(coordinate2[1]) - 1, columns.index(coordinate2[0])
        if (row1 + col1) % 2 == (row2 + col2) % 2:
            return True
        else:
            return False

    def resultsArray(self, queries: List[List[int]], k: int) -> List[int]:
        ans = []
        hq = []
        for x, y in queries:
            dist = abs(x) + abs(y)
            if len(hq) < k:
                heapq.heappush(hq, -dist)
            else:
                if -dist > hq[0]:
                    heapq.heappop(hq)
                    heapq.heappush(hq, -dist)
            if len(hq) < k:
                ans.append(-1)
            else:
                ans.append(-hq[0])
        return ans

    def maxScore(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        sorted_cells = sorted([(grid[row][col], row, col) for row in range(m) for col in range(n)],
                              reverse=True)

        def dfs(row, vis):
            if row == m:
                return 0
            res = dfs(row + 1, vis)
            cnt = 0
            for v, r, c in sorted_cells:
                if r == row and v not in vis:
                    cnt += 1
                    t = v + dfs(row + 1, vis | {v})
                    if t < res and cnt >= m - row:
                        break
                    res = max(res, t)
            return res

        return dfs(0, frozenset())
