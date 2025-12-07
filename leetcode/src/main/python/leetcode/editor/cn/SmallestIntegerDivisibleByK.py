"""
Title: 1015.Smallest Integer Divisible by K
Title Slug: smallestIntegerDivisibleByK
Author: Neo
Date: 2025-11-25 12:32:28
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestRepunitDivByK(self, k: int) -> int:
        n = 1 % k
        for i in range(1, k + 1):
            if n == 0:
                return i
            n = (n * 10 + 1) % k
        return -1
# leetcode submit region end(Prohibit modification and deletion)
