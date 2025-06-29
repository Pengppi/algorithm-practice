"""
Title: 3405.统计恰好有 K 个相等相邻元素的数组数目
Title Slug: countTheNumberOfArraysWithKMatchingAdjacentElements
Author: Neo
Date: 2025-06-17 21:08:11
"""
from math import comb


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        mod = 10 ** 9 + 7
        return comb(n - 1, k) % mod * m * pow(m - 1, n - 1 - k, mod) % mod
# leetcode submit region end(Prohibit modification and deletion)
