"""
Title: 3154.到达第 K 级台阶的方案数
Title Slug: findNumberOfWaysToReachTheKThStair
Author: Neo
Date: 2024-08-20 12:11:32
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def waysToReachStair(self, k: int) -> int:
        @cache
        def dfs(i, jump, flg):
            if i - 1 > k:
                return 0
            res = dfs(i + 2 ** jump, jump + 1, False)
            if i == k:
                res += 1
            if not flg:
                res += dfs(i - 1, jump, True)
            return res

        return dfs(1, 0, False)
# leetcode submit region end(Prohibit modification and deletion)
