"""
Title: 633.平方数之和
Title Slug: sumOfSquareNumbers
Author: Neo
Date: 2024-11-04 13:00:36
"""
from math import isqrt


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        a, b = 0, isqrt(c)
        while a <= b:
            s = a * a + b * b
            if s == c:
                return True
            if s < c:
                a += 1
            else:
                b -= 1
        return False
# leetcode submit region end(Prohibit modification and deletion)
