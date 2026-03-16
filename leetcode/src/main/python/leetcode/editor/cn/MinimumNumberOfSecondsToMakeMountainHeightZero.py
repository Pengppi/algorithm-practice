"""
Title: 3296.Minimum Number of Seconds to Make Mountain Height Zero
Title Slug: minimumNumberOfSecondsToMakeMountainHeightZero
Author: Neo
Date: 2026-03-13 12:52:36
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        def check(limit):
            s = 0
            for timeUnit in workerTimes:
                h = int((-1 + ((1 + 8 * limit / timeUnit) ** 0.5)) / 2)
                s += h
                if s >= mountainHeight:
                    return True
            return False

        l = 0
        r = max(workerTimes) * mountainHeight * mountainHeight
        while l < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1

        return l
# leetcode submit region end(Prohibit modification and deletion)

