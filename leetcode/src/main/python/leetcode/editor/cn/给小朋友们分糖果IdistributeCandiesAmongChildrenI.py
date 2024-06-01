"""
Title: 2928.给小朋友们分糖果 I
Title Slug: distributeCandiesAmongChildrenI
Author: Neo
Date: 2024-06-01 15:33:21
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        @cache
        def dfs(remain: int, i: int) -> int:
            if i == 3:
                return 1 if 0 <= remain <= limit else 0
            if remain < 0:
                return 0
            return sum(dfs(remain - x, i + 1) for x in range(min(remain, limit) + 1))

        return dfs(n, 1)


# leetcode submit region end(Prohibit modification and deletion)
Solution().distributeCandies(5, 2)
