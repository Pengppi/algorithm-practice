"""
Title: 3272.统计好整数的数目
Title Slug: findTheCountOfGoodIntegers
Author: Neo
Date: 2025-04-12 17:00:49
"""
from collections import Counter
from math import factorial


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countGoodIntegers(self, n: int, k: int) -> int:
        fac = [factorial(i) for i in range(n + 1)]
        vis = set()
        base = 10 ** ((n - 1) // 2)
        ans = 0
        for i in range(base, 10 * base):
            s = str(i)
            s += s[::-1][n & 1:]
            if int(s) % k:
                continue

            key = ''.join(sorted(s))
            if key in vis:
                continue
            vis.add(key)

            cnt = Counter(s)
            res = (n - cnt['0']) * fac[n - 1]
            for c in cnt.values():
                res //= fac[c]
            ans += res
        return ans
# leetcode submit region end(Prohibit modification and deletion)
