"""
Title: 3169.Count Days Without Meetings
Title Slug: countDaysWithoutMeetings
Author: Neo
Date: 2025-07-11 18:44:45
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x: x[0])
        cnt = 0
        mx_r = 0
        for l, r in meetings:
            if r < mx_r:
                continue
            l = max(l, mx_r + 1)
            cnt += r - l + 1
            mx_r = max(mx_r, r)
        return days - cnt

# leetcode submit region end(Prohibit modification and deletion)
