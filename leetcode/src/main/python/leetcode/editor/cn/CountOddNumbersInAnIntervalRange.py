"""
Title: 1523.Count Odd Numbers in an Interval Range
Title Slug: countOddNumbersInAnIntervalRange
Author: Neo
Date: 2025-12-07 10:35:30
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def countOdds(self, low: int, high: int) -> int:
        if low == high:
            return low & 1

        tot = high - low + 1
        if low & 1 == 0:
            tot -= 1
        if high & 1 == 0:
            tot -= 1

        return (tot + 1) // 2


# leetcode submit region end(Prohibit modification and deletion)

# 2-10 & 2-9: 3,5,7,9  tot//2
# 1-10 & 1-9: 1,3,5,7,9  (tot+1)//2
