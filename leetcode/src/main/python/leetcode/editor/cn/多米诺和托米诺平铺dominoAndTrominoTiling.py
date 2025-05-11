"""
Title: 790.多米诺和托米诺平铺
Title Slug: dominoAndTrominoTiling
Author: Neo
Date: 2025-05-05 13:51:48
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numTilings(self, n: int) -> int:
        if n == 1:
            return 1
        mod = 10 ** 9 + 7
        f = [0] * (n + 1)
        f[0] = 1
        f[1] = 1
        f[2] = 2
        for i in range(3, n + 1):
            f[i] = (f[i - 1] * 2 + f[i - 3]) % mod
        return f[n]
# leetcode submit region end(Prohibit modification and deletion)
