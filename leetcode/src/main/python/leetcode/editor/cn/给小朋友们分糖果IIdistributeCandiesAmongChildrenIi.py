"""
Title: 2929.给小朋友们分糖果 II
Title Slug: distributeCandiesAmongChildrenIi
Author: Neo
Date: 2025-06-01 22:16:37
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        ans = 0
        for i in range(min(n, limit) + 1):
            if n - i > 2 * limit:
                continue
            ans += min(n - i, limit) - max(0, n - i - limit) + 1
        return ans

        # leetcode submit region end(Prohibit modification and deletion)
