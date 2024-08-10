"""
Title: 3130.找出所有稳定的二进制数组 II
Title Slug: findAllPossibleStableBinaryArraysIi
Author: Neo
Date: 2024-08-07 13:08:23
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        mod = 10 ** 9 + 7

        @cache
        def dfs(i: int, j: int, k: int) -> int:
            if i == 0:
                return 1 if k == 1 and j <= limit else 0
            if j == 0:
                return 1 if k == 0 and i <= limit else 0
            if k == 0:
                return (dfs(i - 1, j, 0) + dfs(i - 1, j, 1)
                        - (dfs(i - 1 - limit, j, 1) if i > limit else 0)) % mod
            else:
                return (dfs(i, j - 1, 0) + dfs(i, j - 1, 1)
                        - (dfs(i, j - 1 - limit, 0) if j > limit else 0)) % mod

        ans = (dfs(zero, one, 0) + dfs(zero, one, 1)) % mod
        dfs.cache_clear()
        return ans

# leetcode submit region end(Prohibit modification and deletion)
