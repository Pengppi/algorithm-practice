"""
Title: 3099.哈沙德数
Title Slug: harshadNumber
Author: Neo
Date: 2024-07-03 12:18:26
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x: int) -> int:
        t = x
        s = 0
        while t > 0:
            s += t % 10
            t //= 10
        return s if x % s == 0 else -1
# leetcode submit region end(Prohibit modification and deletion)
