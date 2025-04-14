"""
Title: 1922.统计好数字的数目
Title Slug: countGoodNumbers
Author: Neo
Date: 2025-04-13 15:03:18
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countGoodNumbers(self, n: int) -> int:
        mod = 10 ** 9 + 7
        even_cnt = (n + 1) // 2
        odd_cnt = n // 2

        return (pow(5, even_cnt, mod) * pow(4, odd_cnt, mod)) % mod
    # leetcode submit region end(Prohibit modification and deletion)
