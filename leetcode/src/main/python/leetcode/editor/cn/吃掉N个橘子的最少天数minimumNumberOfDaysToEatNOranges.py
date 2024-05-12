"""
Title: 1553.吃掉 N 个橘子的最少天数
Title Slug: minimumNumberOfDaysToEatNOranges
Author: Neo
Date: 2024-05-12 00:40:19
"""
from collections import defaultdict
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    @cache
    def minDays(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1
        return min(self.minDays(n // 2) + n % 2, self.minDays(n // 3) + n % 3) + 1

# leetcode submit region end(Prohibit modification and deletion)
