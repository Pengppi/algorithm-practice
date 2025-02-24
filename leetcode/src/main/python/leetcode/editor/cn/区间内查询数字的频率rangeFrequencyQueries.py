"""
Title: 2080.区间内查询数字的频率
Title Slug: rangeFrequencyQueries
Author: Neo
Date: 2025-02-18 12:46:36
"""
from bisect import bisect_left, bisect_right
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class RangeFreqQuery:

    def __init__(self, arr: List[int]):
        mp = defaultdict(list)
        for i, x in enumerate(arr):
            mp[x].append(i)
        self.mp = mp

    def query(self, left: int, right: int, value: int) -> int:
        mp = self.mp
        if value not in mp:
            return 0
        arr = mp[value]
        l = bisect_left(arr, left)
        r = bisect_right(arr, right)
        return r - l

# Your RangeFreqQuery object will be instantiated and called as such:
# obj = RangeFreqQuery(arr)
# param_1 = obj.query(left,right,value)
# leetcode submit region end(Prohibit modification and deletion)