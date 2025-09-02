"""
Title: 3363.Find the Maximum Number of Fruits Collected
Title Slug: findTheMaximumNumberOfFruitsCollected
Author: Neo
Date: 2025-08-07 19:00:17
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxCollectedFruits(self, fruits: List[List[int]]) -> int:
        n = len(fruits)
        ans = sum(row[i] for i, row in enumerate(fruits))

        @cache
        def dfs(i: int, j: int) -> int:
            if not (n - 1 - i <= j < n):
                return 0
            if i == 0:
                return fruits[i][j]
            return max(dfs(i - 1, j - 1), dfs(i - 1, j), dfs(i - 1, j + 1)) + fruits[i][j]

        ans += dfs(n - 2, n - 1)
        dfs.cache_clear()
        fruits = list(zip(*fruits))
        ans += dfs(n - 2, n - 1)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
