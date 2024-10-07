"""
Title: 2187.完成旅途的最少时间
Title Slug: minimumTimeToCompleteTrips
Author: Neo
Date: 2024-10-05 19:42:40
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        def check(x: int) -> bool:
            s = 0
            for t in time:
                s += x // t
            return s >= totalTrips

        l = 1
        r = totalTrips * min(time)
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return r

# leetcode submit region end(Prohibit modification and deletion)
