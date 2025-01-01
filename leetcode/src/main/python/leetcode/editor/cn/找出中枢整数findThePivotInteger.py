"""
Title: 2485.找出中枢整数
Title Slug: findThePivotInteger
Author: Neo
Date: 2025-01-01 17:25:49
"""
import math


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pivotInteger(self, n: int) -> int:
        s1 = n * n + n
        if s1 & 1:
            return -1
        s = s1 >> 1
        res = math.isqrt(s)
        if res * res == s:
            return res
        return -1
# leetcode submit region end(Prohibit modification and deletion)
