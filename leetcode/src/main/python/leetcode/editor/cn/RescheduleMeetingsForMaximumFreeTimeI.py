"""
Title: 3439.Reschedule Meetings for Maximum Free Time I
Title Slug: rescheduleMeetingsForMaximumFreeTimeI
Author: Neo
Date: 2025-07-09 23:19:47
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxFreeTime(self, eventTime: int, k: int, startTime: List[int], endTime: List[int]) -> int:
        n = len(startTime)
        free = [0] * (n + 1)
        free[0] = startTime[0]
        for i in range(1, n):
            free[i] = startTime[i] - endTime[i - 1]
        free[-1] = eventTime - endTime[-1]

        tot = ans = 0
        for i, f in enumerate(free):
            tot += f
            if i < k:
                continue
            ans = max(ans, tot)
            tot -= free[i - k]
        return  ans

# leetcode submit region end(Prohibit modification and deletion)
