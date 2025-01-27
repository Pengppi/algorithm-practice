"""
Title: 2412.完成所有交易的初始最少钱数
Title Slug: minimumMoneyRequiredBeforeTransactions
Author: Neo
Date: 2025-01-25 18:40:23
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumMoney(self, transactions: List[List[int]]) -> int:
        lose = mx = 0
        for a, b in transactions:
            lose += max(0, a - b)
            mx = max(mx, min(a, b))
        return lose + mx


# leetcode submit region end(Prohibit modification and deletion)


Solution().minimumMoney([[2, 1], [5, 0], [4, 2]])
