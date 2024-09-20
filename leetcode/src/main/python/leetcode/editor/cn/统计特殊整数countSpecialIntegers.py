"""
Title: 2376.统计特殊整数
Title Slug: countSpecialIntegers
Author: Neo
Date: 2024-09-20 12:33:13
"""
from linecache import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        s = str(n)

        @cache
        def dfs(i: int, mask: int, is_limit: bool, is_num: bool) -> int:
            if i == len(s):
                return int(is_num)

            res = 0
            if not is_num:
                res += dfs(i + 1, mask, False, False)

            ceil = int(s[i]) if is_limit else 9
            for d in range(1 - int(is_num), ceil + 1):
                if mask & (1 << d) == 0:
                    res += dfs(i + 1, mask | (1 << d), is_limit and d == ceil, True)
            return res

        return dfs(0, 0, True, False)

# leetcode submit region end(Prohibit modification and deletion)
