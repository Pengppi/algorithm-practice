"""
Title: 3116.单面值组合的第 K 小金额
Title Slug: kthSmallestAmountWithSingleDenominationCombination
Author: Neo
Date: 2024-05-14 14:18:32
"""
from bisect import bisect_left
from math import lcm
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findKthSmallest(self, coins: List[int], k: int) -> int:
        n = len(coins)

        def check(m: int) -> int:
            cnt = 0
            for i in range(1, 1 << n):
                lcm_res = 1
                for j, x in enumerate(coins):
                    if i >> j & 1:
                        lcm_res = lcm(lcm_res, x)

                c = m // lcm_res
                cnt += c if i.bit_count() % 2 else -c
            return cnt >= k

        return bisect_left(range(min(coins) * k), True, k, key=check)

# leetcode submit region end(Prohibit modification and deletion)
