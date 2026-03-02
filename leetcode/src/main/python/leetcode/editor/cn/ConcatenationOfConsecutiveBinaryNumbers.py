"""
Title: 1680.Concatenation of Consecutive Binary Numbers
Title Slug: concatenationOfConsecutiveBinaryNumbers
Author: Neo
Date: 2026-02-28 12:50:59
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def concatenatedBinary(self, n: int) -> int:
        mod = 10**9 + 7
        ans = 0
        for x in range(1, n + 1):
            w = x.bit_length()
            ans = (ans << w | x) % mod
        return ans


# leetcode submit region end(Prohibit modification and deletion)
