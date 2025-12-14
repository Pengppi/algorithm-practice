"""
Title: 2147.Number of Ways to Divide a Long Corridor
Title Slug: numberOfWaysToDivideALongCorridor
Author: Neo
Date: 2025-12-14 12:28:43
"""

# leetcode submit region begin(Prohibit modification and deletion)
from bisect import bisect, bisect_left
from functools import cache


class Solution:
    def numberOfWays(self, corridor: str) -> int:
        mod = 10**9 + 7
        n = len(corridor)
        ans = 1
        cnt_s = last_s = 0
        for i, c in enumerate(corridor):
            if c == "S":
                cnt_s += 1
                if cnt_s >= 3 and cnt_s & 1:
                    ans *= i - last_s
                    ans %= mod
                last_s = i
        if cnt_s & 1 or cnt_s == 0:
            return 0

        return ans


# leetcode submit region end(Prohibit modification and deletion)
