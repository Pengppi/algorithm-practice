"""
Title: 837.New 21 Game
Title Slug: new21Game
Author: Neo
Date: 2025-08-17 15:43:52
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        f = [0.0] * (n + 1 + maxPts)
        for success_point in range(k, n + 1):
            f[success_point] = 1.0

        ws = sum(f[k:k + maxPts])
        for i in range(k - 1, -1, -1):
            f[i] = ws / maxPts
            ws = ws - f[i + maxPts] + f[i]
        return f[0]
    # leetcode submit region end(Prohibit modification and deletion)
