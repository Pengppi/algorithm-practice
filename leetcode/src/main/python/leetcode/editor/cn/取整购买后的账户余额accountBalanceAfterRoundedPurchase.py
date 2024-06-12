"""
Title: 2806.取整购买后的账户余额
Title Slug: accountBalanceAfterRoundedPurchase
Author: Neo
Date: 2024-06-12 12:35:34
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def accountBalanceAfterPurchase(self, purchaseAmount: int) -> int:
        return 100 - (purchaseAmount + 5) // 10 * 10
# leetcode submit region end(Prohibit modification and deletion)
