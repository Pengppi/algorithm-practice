"""
Title: 3130.Find All Possible Stable Binary Arrays II
Title Slug: findAllPossibleStableBinaryArraysIi
Author: Neo
Date: 2026-03-10 12:31:49
"""

# leetcode submit region begin(Prohibit modification and deletion)
from functools import cache


class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        mod = 10**9 + 7

        @cache
        def dfs(i: int, j: int, k: int) -> int:
            if i == 0:
                return 1 if k == 1 and j <= limit else 0
            if j == 0:
                return 1 if k == 0 and i <= limit else 0
            if k == 0:
                return (
                    dfs(i - 1, j, 1)
                    + dfs(i - 1, j, 0)
                    - (dfs(i - limit - 1, j, 1) if i > limit else 0)
                ) % mod
            else:
                return (
                    dfs(i, j - 1, 0)
                    + dfs(i, j - 1, 1)
                    - (dfs(i, j - limit - 1, 0) if j > limit else 0)
                ) % mod

        ans = dfs(zero, one, 0) + dfs(zero, one, 1)
        dfs.cache_clear()
        return ans % mod


# leetcode submit region end(Prohibit modification and deletion)
