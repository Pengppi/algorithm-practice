"""
Title: 2850.将石头分散到网格图的最少移动次数
Title Slug: minimumMovesToSpreadStonesOverGrid
Author: Neo
Date: 2024-07-20 18:17:27
"""
from cmath import inf
from itertools import permutations
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        n = len(grid)
        f, t = [], []
        for i in range(n):
            for j in range(n):
                cnt = grid[i][j]
                if cnt > 1:
                    f.extend([(i, j)] * (cnt - 1))
                elif cnt == 0:
                    t.append((i, j))

        ans = inf
        for ff in permutations(f):
            tot = 0
            for (x1, y1), (x2, y2) in zip(ff, t):
                tot += abs(x1 - x2) + abs(y1 - y2)
            ans = min(ans, tot)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
