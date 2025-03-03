"""
Title: 1656.设计有序流
Title Slug: designAnOrderedStream
Author: Neo
Date: 2025-02-24 12:10:25
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class OrderedStream:

    def __init__(self, n: int):
        self.arr = [''] * (n + 1)
        self.ptr = 1

    def insert(self, idKey: int, value: str) -> List[str]:
        self.arr[idKey] = value
        res = []
        while self.ptr < len(self.arr) and self.arr[self.ptr] != '':
            res.append(self.arr[self.ptr])
            self.ptr += 1
        return res

# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)
# leetcode submit region end(Prohibit modification and deletion)
