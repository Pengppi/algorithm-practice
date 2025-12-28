"""
Title: 2483.Minimum Penalty for a Shop
Title Slug: minimumPenaltyForAShop
Author: Neo
Date: 2025-12-26 15:24:48
"""

# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def bestClosingTime(self, customers: str) -> int:
        mn_penalty = penalty = customers.count("Y")
        ans = 0
        for i, c in enumerate(customers):
            penalty += 1 if c == "N" else -1
            if penalty < mn_penalty:
                mn_penalty = penalty
                ans = i + 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().bestClosingTime("YYNY")
