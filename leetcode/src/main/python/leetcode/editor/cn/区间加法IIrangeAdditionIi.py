"""
Title: 598.区间加法 II
Title Slug: rangeAdditionIi
Author: Neo
Date: 2025-02-02 21:10:21
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        ma = m
        mb = n
        for a, b in ops:
            ma = min(ma, a)
            mb = min(mb, b)
        return ma * mb

# leetcode submit region end(Prohibit modification and deletion)
