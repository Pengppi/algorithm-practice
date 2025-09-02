"""
Title: 808.Soup Servings
Title Slug: soupServings
Author: Neo
Date: 2025-08-08 18:38:39
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def soupServings(self, n: int) -> float:

        @cache
        def dfs(x: int, y: int) -> float:
            if x <= 0 and y <= 0:
                return 0.5
            if x <= 0:
                return 1.0
            if y <= 0:
                return 0.0
            return 0.25 * (dfs(x - 100, y) + dfs(x - 75, y - 25) + dfs(x - 50, y - 50) + dfs(x - 25, y - 75))

        if n > 5000:
            return 1.0

        return dfs(n, n)

# leetcode submit region end(Prohibit modification and deletion)
