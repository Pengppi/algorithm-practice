"""
Title: 1622.Fancy Sequence
Title Slug: fancySequence
Author: Neo
Date: 2026-03-15 10:15:04
"""

# leetcode submit region begin(Prohibit modification and deletion)
mod = 10**9 + 7


class Fancy:
    def __init__(self):
        self.values = []
        self.add = 0
        self.mult = 1

    def append(self, val: int) -> None:
        val = (val - self.add) * pow(self.mult, -1, mod) % mod
        self.values.append(val)

    def addAll(self, inc: int) -> None:
        self.add += inc

    def multAll(self, m: int) -> None:
        self.mult = m * self.mult % mod
        self.add = m * self.add % mod

    def getIndex(self, idx: int) -> int:
        if idx >= len(self.values):
            return -1
        return (self.values[idx] * self.mult + self.add) % mod


# Your Fancy object will be instantiated and called as such:
# obj = Fancy()
# obj.append(val)
# obj.addAll(inc)
# obj.multAll(m)
# param_4 = obj.getIndex(idx)
# leetcode submit region end(Prohibit modification and deletion)
