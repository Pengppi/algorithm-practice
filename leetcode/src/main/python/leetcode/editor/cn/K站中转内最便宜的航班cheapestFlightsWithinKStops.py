"""
Title: 787.K 站中转内最便宜的航班
Title Slug: cheapestFlightsWithinKStops
Author: Neo
Date: 2024-05-04 16:54:47
"""
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        f = [[inf] * n for _ in range(k + 2)]
        f[0][src] = 0
        ans = inf
        for t in range(1, k + 2):
            for i, j, p in flights:
                f[t][j] = min(f[t][j], f[t - 1][i] + p)
            ans = min(ans, f[t][dst])

        return -1 if ans == inf else ans
# leetcode submit region end(Prohibit modification and deletion)
