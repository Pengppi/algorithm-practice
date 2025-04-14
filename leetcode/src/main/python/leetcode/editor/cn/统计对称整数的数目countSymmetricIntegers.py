"""
Title: 2843.统计对称整数的数目
Title Slug: countSymmetricIntegers
Author: Neo
Date: 2025-04-11 19:37:19
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSymmetricIntegers(self, low: int, high: int) -> int:
        high = list(map(int, str(high)))
        n = len(high)
        low = list(map(int, str(low).zfill(n)))

        @cache
        def dfs(i, limit_low, limit_high, diff, first_num):
            if i == n:
                return 1 if diff == 0 else 0

            lo = low[i] if limit_low else 0
            hi = high[i] if limit_high else 9

            if first_num < 0 and (n - i) & 1:
                return 0 if lo else dfs(i + 1, True, False, diff, -1)

            res = 0
            is_left = first_num < 0 or i < (first_num + n) // 2
            for d in range(lo, hi + 1):
                new_diff = diff + (d if is_left else -d)
                res += dfs(i + 1, limit_low and d == lo, limit_high and d == hi, new_diff, i if first_num < 0 and d else first_num)

            return res

        return dfs(0, True, True, 0, -1)
# leetcode submit region end(Prohibit modification and deletion)
