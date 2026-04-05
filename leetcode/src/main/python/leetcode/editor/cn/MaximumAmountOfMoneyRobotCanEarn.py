"""
Title: 3418.Maximum Amount of Money Robot Can Earn
Title Slug: maximumAmountOfMoneyRobotCanEarn
Author: Neo
Date: 2026-04-02 23:50:27
"""

# leetcode submit region begin(Prohibit modification and deletion)
from functools import cache
from math import inf
from typing import List


class Solution:
    def maximumAmount(self, coins: List[List[int]]) -> int:
        m, n = len(coins), len(coins[0])

        @cache
        def dfs(i: int, j: int, k: int) -> int:
            if i >= m or j >= n:
                return -inf  # pyright: ignore[reportReturnType]
            cur = coins[i][j]
            if i == m - 1 and j == n - 1:
                return max(cur, 0) if k else cur
            res = max(dfs(i + 1, j, k), dfs(i, j + 1, k)) + cur
            if cur < 0 and k:
                res = max(res, dfs(i + 1, j, k - 1), dfs(i, j + 1, k - 1))

            return res

        ans = dfs(0, 0, 2)
        dfs.cache_clear()
        return ans


# leetcode submit region end(Prohibit modification and deletion)
