"""
Title: 3007.价值和小于等于 K 的最大数字
Title Slug: maximumNumberThatSumOfThePricesIsLessThanOrEqualToK
Author: Neo
Date: 2024-08-21 12:48:15
"""
from bisect import bisect_left
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMaximumNumber(self, k: int, x: int) -> int:
        def getPrice(num):
            @cache
            def dfs(i, cnt, limit):
                if i == 0:
                    return cnt
                res = 0
                up = num >> (i - 1) & 1 if limit else 1
                for d in range(up + 1):
                    res += dfs(i - 1, cnt + (d == 1 and i % x == 0), limit and d == up)
                return res

            return dfs(num.bit_length(), 0, True)

        return bisect_left(range((k + 1) << x), k + 1, key=getPrice) - 1


# leetcode submit region end(Prohibit modification and deletion)
Solution().findMaximumNumber(9, 1)
