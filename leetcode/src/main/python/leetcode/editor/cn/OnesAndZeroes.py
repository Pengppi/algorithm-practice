"""
Title: 474.Ones and Zeroes
Title Slug: onesAndZeroes
Author: Neo
Date: 2025-11-11 12:24:16
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        cnt0 = [s.count('0') for s in strs]

        @cache
        def sel_or_not(i: int, zero_cnt: int, one_cnt: int) -> int:
            if i >= len(strs):
                return 0
            res = sel_or_not(i + 1, zero_cnt, one_cnt)
            cnt1 = len(strs[i]) - cnt0[i]
            if zero_cnt >= cnt0[i] and one_cnt >= cnt1:
                res = max(res, sel_or_not(i + 1, zero_cnt - cnt0[i], one_cnt - cnt1) + 1)
            return res

        return sel_or_not(0, m, n)

# leetcode submit region end(Prohibit modification and deletion)
