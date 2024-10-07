"""
Title: 871.最低加油次数
Title Slug: minimumNumberOfRefuelingStops
Author: Neo
Date: 2024-10-07 10:48:52
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        n = len(stations)
        f = [startFuel] + [0] * n
        for i, (pos, fu) in enumerate(stations):
            for j in range(i, -1, -1):
                if f[j] >= pos:
                    f[j + 1] = max(f[j + 1], f[j] + fu)

        for i in range(n + 1):
            if f[i] >= target:
                return i
        return -1

# leetcode submit region end(Prohibit modification and deletion)
