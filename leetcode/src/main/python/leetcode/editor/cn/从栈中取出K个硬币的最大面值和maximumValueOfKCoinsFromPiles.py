"""
Title: 2218.从栈中取出 K 个硬币的最大面值和
Title Slug: maximumValueOfKCoinsFromPiles
Author: Neo
Date: 2025-01-21 12:22:09
"""
from functools import cache
from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        n = len(piles)

        @cache
        def dfs(i, j):
            if i < 0:
                return 0
            res = dfs(i - 1, j)
            for c, v in enumerate(accumulate(piles[i][:j])):
                res = max(res, v + dfs(i - 1, j - c - 1))
            return res

        return dfs(n - 1, k)

# leetcode submit region end(Prohibit modification and deletion)
