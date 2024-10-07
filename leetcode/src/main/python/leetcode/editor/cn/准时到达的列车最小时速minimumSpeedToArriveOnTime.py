"""
Title: 1870.准时到达的列车最小时速
Title Slug: minimumSpeedToArriveOnTime
Author: Neo
Date: 2024-10-02 14:14:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        n = len(dist)
        hour = round(hour * 100)
        if hour <= (n - 1) * 100:
            return -1

        def check(v: int) -> bool:
            s = 0
            for i in range(n - 1):
                s += (dist[i] + v - 1) // v

            return (s * v + dist[-1]) * 100 <= hour * v

        l, r = 1, 10 ** 7
        while l < r:
            m = (l + r) // 2
            if check(m):
                r = m
            else:
                l = m + 1
        return r

# leetcode submit region end(Prohibit modification and deletion)
