"""
Title: 2787.Ways to Express an Integer as Sum of Powers
Title Slug: waysToExpressAnIntegerAsSumOfPowers
Author: Neo
Date: 2025-08-12 22:37:32
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        mod = 10 ** 9 + 7
        f = [0] * (n + 1)
        f[0] = 1
        for i in range(1, n + 1):
            cur = i ** x
            if cur > n:
                break
            for j in range(n, cur - 1, -1):
                f[j] = (f[j] + f[j - cur] ) % mod
        return f[n]
# leetcode submit region end(Prohibit modification and deletion)
