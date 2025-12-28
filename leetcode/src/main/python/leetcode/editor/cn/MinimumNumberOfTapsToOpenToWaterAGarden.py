"""
Title: 1326.Minimum Number of Taps to Open to Water a Garden
Title Slug: minimumNumberOfTapsToOpenToWaterAGarden
Author: Neo
Date: 2025-12-26 19:38:35
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minTaps(self, n: int, ranges: List[int]) -> int:
        range_intervals = []
        for i, r in enumerate(ranges):
            range_intervals.append((max(0, i - r), i + r))
        range_intervals.sort(key=lambda x: (x[0], -x[1]))
        ans = 1
        curEnd = range_intervals[0][1]
        nextEnd = curEnd
        for i in range(1, len(range_intervals)):
            l, r = range_intervals[i]
            if curEnd < l:
                if nextEnd < l:
                    return -1
                ans += 1
                curEnd = nextEnd
            if curEnd < r:
                nextEnd = max(nextEnd, r)
        if curEnd < n and nextEnd >= n:
            return ans + 1
        elif curEnd >= n:
            return ans
        else:
            return -1


# leetcode submit region end(Prohibit modification and deletion)
Solution().minTaps(7, [1, 2, 1, 0, 2, 1, 0, 1])
