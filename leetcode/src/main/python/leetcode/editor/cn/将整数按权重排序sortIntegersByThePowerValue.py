"""
Title: 1387.将整数按权重排序
Title Slug: sortIntegersByThePowerValue
Author: Neo
Date: 2024-12-22 12:39:58
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getKth(self, lo: int, hi: int, k: int) -> int:
        @cache
        def get_step(x):
            if x == 1:
                return 0
            if x & 1:
                return 1 + get_step(3 * x + 1)
            else:
                return 1 + get_step(x // 2)

        return sorted(range(lo, hi + 1), key=get_step)[k - 1]

# leetcode submit region end(Prohibit modification and deletion)
