"""
Title: 731.我的日程安排表 II
Title Slug: myCalendarIi
Author: Neo
Date: 2025-01-03 21:18:13
"""

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class MyCalendarTwo:

    def __init__(self):
        self.booked = SortedList(key=lambda x: (x[0], x[1]))
        self.overlap = SortedList(key=lambda x: (x[0], x[1]))

    def book(self, startTime: int, endTime: int) -> bool:
        for start, end in self.overlap:
            if max(start, startTime) < min(end, endTime):
                return False
            if start > endTime:
                break
        for start,end in self.booked:
            if max(start, startTime) < min(end, endTime):
                self.overlap.add((max(start, startTime), min(end, endTime)))
            if start > endTime:
                break

        self.booked.add((startTime, endTime))
        return True

# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(startTime,endTime)
# leetcode submit region end(Prohibit modification and deletion)
