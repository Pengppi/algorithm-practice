"""
Title: 732.我的日程安排表 III
Title Slug: myCalendarIii
Author: Neo
Date: 2025-01-04 21:13:26
"""
from sortedcontainers import SortedDict


# leetcode submit region begin(Prohibit modification and deletion)
class MyCalendarThree:

    def __init__(self):
        self.cnt = SortedDict()

    def book(self, startTime: int, endTime: int) -> int:
        cnt = self.cnt
        cnt[startTime] = cnt.get(startTime, 0) + 1
        cnt[endTime] = cnt.get(endTime, 0) - 1
        ans = mx = 0
        for freq in cnt.values():
            mx += freq
            ans = max(ans, mx)
        return ans


# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(startTime,endTime)
# leetcode submit region end(Prohibit modification and deletion)

