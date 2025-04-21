"""
Title: 2563.统计公平数对的数目
Title Slug: countTheNumberOfFairPairs
Author: Neo
Date: 2025-04-19 17:05:02
"""
from typing import List

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        sl = SortedList()
        sl.add(nums[0])
        ans = 0
        for x in nums[1:]:
            lo = lower - x
            hi = upper - x
            l = sl.bisect_left(lo)
            r = sl.bisect_right(hi)
            ans += r - l
            sl.add(x)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
