"""
Title: 3652.Best Time to Buy and Sell Stock using Strategy
Title Slug: bestTimeToBuyAndSellStockUsingStrategy
Author: Neo
Date: 2025-12-18 18:57:39
"""

from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def maxProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
        n = len(prices)
        profits = [a * b for a, b in zip(prices, strategy)]
        ans = sum(profits)
        ps1 = list(accumulate(prices, initial=0))
        ps2 = list(accumulate(profits, initial=0))
        n = len(prices)
        for i in range(n - k + 1):
            not_changed = ps2[i] + ps2[n] - ps2[i + k]
            changed = ps1[i + k] - ps1[i + k // 2]
            ans = max(ans, not_changed + changed)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().maxProfit(prices=[5, 8], strategy=[-1, 1], k=2)
