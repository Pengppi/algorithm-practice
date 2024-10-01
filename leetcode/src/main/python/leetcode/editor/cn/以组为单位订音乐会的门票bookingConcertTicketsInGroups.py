"""
Title: 2286.以组为单位订音乐会的门票
Title Slug: bookingConcertTicketsInGroups
Author: Neo
Date: 2024-09-28 19:23:46
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class BookMyShow:
    def __init__(self, n: int, m: int):
        self.n = n
        self.m = m
        self.min = [0] * (4 * n)  # 相比 4n 空间更小
        self.sum = [0] * (4 * n)

    def gather(self, k: int, maxRow: int) -> List[int]:
        # 找第一个能倒入 k 升水的水桶
        r = self.find_min(0, 0, self.n - 1, maxRow, self.m - k)
        if r < 0:  # 没有这样的水桶
            return []
        c = self.query_sum(0, 0, self.n - 1, r, r)
        self.update(0, 0, self.n - 1, r, k)  # 倒水
        return [r, c]

    def scatter(self, k: int, maxRow: int) -> bool:
        s = self.query_sum(0, 0, self.n - 1, 0, maxRow)
        if s > self.m * (maxRow + 1) - k:
            return False
        i = self.find_min(0, 0, self.n - 1, maxRow, self.m - 1)
        while k:
            left = min(self.m - self.query_sum(0, 0, self.n - 1, i, i), k)
            self.update(0, 0, self.n - 1, i, left)  # 倒水
            k -= left
            i += 1
        return True

    def update(self, o: int, l: int, r: int, i: int, val: int) -> None:
        if l == r:
            self.min[o] += val
            self.sum[o] += val
            return
        m = (l + r) // 2
        if i <= m:
            self.update(o * 2 + 1, l, m, i, val)
        else:
            self.update(o * 2 + 2, m + 1, r, i, val)
        self.min[o] = min(self.min[o * 2 + 1], self.min[o * 2 + 2])
        self.sum[o] = self.sum[o * 2 + 1] + self.sum[o * 2 + 2]

    def query_sum(self, o: int, l: int, r: int, L: int, R: int) -> int:
        if L <= l and r <= R:
            return self.sum[o]
        res = 0
        m = (l + r) // 2
        if L <= m:
            res = self.query_sum(o * 2 + 1, l, m, L, R)
        if R > m:
            res += self.query_sum(o * 2 + 2, m + 1, r, L, R)
        return res

    def find_min(self, o: int, l: int, r: int, R: int, val: int) -> int:
        if self.min[o] > val:
            return -1
        if l == r:
            return l
        m = (l + r) // 2
        if self.min[o * 2 + 1] <= val:
            return self.find_min(o * 2 + 1, l, m, R, val)
        if R > m:
            return self.find_min(o * 2 + 2, m + 1, r, R, val)
        return -1
    # Your BookMyShow object will be instantiated and called as such:
    # obj = BookMyShow(n, m)
    # param_1 = obj.gather(k,maxRow)
    # param_2 = obj.scatter(k,maxRow)
    # leetcode submit region end(Prohibit modification and deletion)
