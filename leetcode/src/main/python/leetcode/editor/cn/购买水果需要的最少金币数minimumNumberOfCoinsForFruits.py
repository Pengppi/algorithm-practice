"""
Title: 2944.购买水果需要的最少金币数
Title Slug: minimumNumberOfCoinsForFruits
Author: Neo
Date: 2025-01-24 12:15:32
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumCoins(self, prices: List[int]) -> int:
        n = len(prices)

        @cache
        def dfs(i):
            if i * 2 >= n:
                return prices[i - 1]
            return min(dfs(j) for j in range(i + 1, i * 2 + 2)) + prices[i - 1]


        return dfs(1)

# leetcode submit region end(Prohibit modification and deletion)
