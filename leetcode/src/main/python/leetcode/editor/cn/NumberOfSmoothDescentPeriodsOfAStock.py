"""
Title: 2110.Number of Smooth Descent Periods of a Stock
Title Slug: numberOfSmoothDescentPeriodsOfAStock
Author: Neo
Date: 2025-12-15 14:41:39
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getDescentPeriods(self, prices: List[int]) -> int:
        ans = len(prices)
        wd = 0
        for i, p in enumerate(prices[1:], 1):
            if p + 1 == prices[i - 1]:
                wd += 1
            else:
                wd = 0
            ans += wd

        return ans
# leetcode submit region end(Prohibit modification and deletion)
