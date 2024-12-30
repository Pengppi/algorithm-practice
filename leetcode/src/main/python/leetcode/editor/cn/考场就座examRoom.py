"""
Title: 855.考场就座
Title Slug: examRoom
Author: Neo
Date: 2024-12-23 12:14:02
"""
from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class ExamRoom:
    def add(self, interval):
        l, r = interval
        self.intervals.add(interval)
        self.right[l] = r
        self.left[r] = l

    def delete(self, interval):
        l, r = interval
        self.intervals.remove(interval)
        self.right.pop(l)
        self.left.pop(r)

    def __init__(self, n: int):
        def dist(interval):
            l, r = interval
            return r - l - 1 if l == -1 or r == n else (r - l) >> 1

        self.n = n
        self.intervals = SortedList(key=lambda x: (-dist(x), x[0],))
        self.left = {}
        self.right = {}
        self.add((-1, n))

    def seat(self) -> int:
        l, r = self.intervals[0]
        p = (l + r) >> 1
        if l == -1:
            p = 0
        elif r == self.n:
            p = self.n - 1
        self.delete((l, r))
        self.add((l, p))
        self.add((p, r))
        return p

    def leave(self, p: int) -> None:
        l, r = self.left[p], self.right[p]
        self.delete((l, p))
        self.delete((p, r))
        self.add((l, r))

# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(n)
# param_1 = obj.seat()
# obj.leave(p)
# leetcode submit region end(Prohibit modification and deletion)
