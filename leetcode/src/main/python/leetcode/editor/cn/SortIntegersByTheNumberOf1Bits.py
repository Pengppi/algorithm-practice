"""
Title: 1356.Sort Integers by The Number of 1 Bits
Title Slug: sortIntegersByTheNumberOf1Bits
Author: Neo
Date: 2026-02-25 10:11:24
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:

        arr.sort(key=lambda x: (x.bit_count(), x))
        return arr


# leetcode submit region end(Prohibit modification and deletion)
