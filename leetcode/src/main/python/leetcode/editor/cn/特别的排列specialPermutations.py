"""
Title: 2741.特别的排列
Title Slug: specialPermutations
Author: Neo
Date: 2024-06-26 12:22:56
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        MOD = 10 ** 9 + 7
        full = (1 << len(nums)) - 1

        @cache
        def dfs(vis: int, last: int) -> int:
            if vis == full:
                return 1
            res = 0
            for i, x in enumerate(nums):
                cur = 1 << i
                if vis & cur == 0 and (x % last == 0 or last % x == 0):
                    res = (res + dfs(vis | cur, x)) % MOD
            return res

        return dfs(0, 1)
    # leetcode submit region end(Prohibit modification and deletion)
