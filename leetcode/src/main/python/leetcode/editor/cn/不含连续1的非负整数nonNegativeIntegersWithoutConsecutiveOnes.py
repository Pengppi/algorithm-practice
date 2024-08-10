"""
Title: 600.不含连续1的非负整数
Title Slug: nonNegativeIntegersWithoutConsecutiveOnes
Author: Neo
Date: 2024-08-05 16:54:38
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findIntegers(self, n: int) -> int:
        @cache
        def dfs(i: int, pre_num: bool, is_limit: bool):
            if i < 0:
                return 1
            up = n >> i & 1 if is_limit else 1
            res = dfs(i - 1, False, is_limit and up == 0)
            if not pre_num and up == 1:
                res += dfs(i - 1, True, is_limit)
            return res

        return dfs(n.bit_length() - 1, False, True)

# leetcode submit region end(Prohibit modification and deletion)
