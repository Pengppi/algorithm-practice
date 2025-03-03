"""
Title: 729.我的日程安排表 I
Title Slug: myCalendarI
Author: Neo
Date: 2025-02-27 23:52:51
"""
from sortedcontainers import SortedDict


# leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar:

    def __init__(self):
        self.sd = SortedDict()

    def book(self, start: int, end: int) -> bool:
        idx = self.sd.bisect_right(start)
        if idx < len(self.sd) and self.sd.values()[idx] < end:
            return False
        self.sd[end] = start
        return True

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(startTime,endTime)
# leetcode submit region end(Prohibit modification and deletion)
