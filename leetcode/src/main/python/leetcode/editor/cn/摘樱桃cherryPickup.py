"""
Title: 741.摘樱桃
Title Slug: cherryPickup
Author: Neo
Date: 2024-05-06 00:23:42
"""
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        n = len(grid)
        f = [[-inf] * n for _ in range(n)]
        f[0][0] = grid[0][0]
        for k in range(1, 2 * n - 1):
            for x1 in range(min(n - 1, k), max(-1, k - n), -1):
                y1 = k - x1
                for x2 in range(min(k, n - 1), x1 - 1, -1):
                    y2 = k - x2
                    if grid[x1][y1] == -1 or grid[x2][y2] == -1:
                        f[x1][x2] = -inf
                        continue
                    res = f[x1][x2]
                    if x1:
                        res = max(res, f[x1 - 1][x2])
                    if x2:
                        res = max(res, f[x1][x2 - 1])
                    if x1 and x2:
                        res = max(res, f[x1 - 1][x2 - 1])
                    res += grid[x1][y1]
                    if x1 != x2:
                        res += grid[x2][y2]
                    f[x1][x2] = res

        return max(f[-1][-1], 0)
# leetcode submit region end(Prohibit modification and deletion)
