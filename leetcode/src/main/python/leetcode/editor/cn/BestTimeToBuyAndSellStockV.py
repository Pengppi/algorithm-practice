"""
Title: 3573.Best Time to Buy and Sell Stock V
Title Slug: bestTimeToBuyAndSellStockV
Author: Neo
Date: 2025-12-17 23:06:09
"""

from functools import cache
from typing import List

inf = 2 << 31 - 1

# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def maximumProfit(self, prices: List[int], k: int) -> int:
        # state = 0 no stock
        # state = 1 having stock
        # state = 2 waiting to buy
        @cache
        def dfs(i: int, j: int, state: int) -> int:
            if j < 0:
                return -inf
            if i < 0:
                return -inf if state else 0
            p = prices[i]
            if state == 0:
                return max(dfs(i - 1, j, 0), dfs(i - 1, j, 1) + p, dfs(i - 1, j, 2) - p)
            if state == 1:
                return max(
                    dfs(i - 1, j - 1, 0) - p,
                    dfs(i - 1, j, 1),
                )
            return max(dfs(i - 1, j, 2), dfs(i - 1, j - 1, 0) + p)

        ans = dfs(len(prices) - 1, k, 0)
        dfs.cache_clear()

        return ans


# leetcode submit region end(Prohibit modification and deletion)
