"""
Title: 2438.Range Product Queries of Powers
Title Slug: rangeProductQueriesOfPowers
Author: Neo
Date: 2025-08-11 18:42:45
"""
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
mod = 10 ** 9 + 7
mx = (1 + 32) // 2 * 32
pow2 = [0] * mx
pow2[0] = 1
for i in range(1, mx):
    pow2[i] = pow2[i - 1] * 2 % mod


class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        s = [0]
        while n:
            lower_bit = n & -n
            s.append(s[-1] + lower_bit.bit_length() - 1)
            n ^= lower_bit

        return [pow2[s[r + 1] - s[l]] for l, r in queries]

# leetcode submit region end(Prohibit modification and deletion)
