"""
Title: 1492.n 的第 k 个因子
Title Slug: theKthFactorOfN
Author: Neo
Date: 2024-05-05 14:23:58
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        cnt = 0
        x = 1
        while x * x <= n:
            if n % x == 0:
                cnt += 1
                if cnt == k:
                    return x
            x += 1
        x -= 1
        if x * x == n:
            x -= 1

        while x >= 1:
            if n % x == 0:
                cnt += 1
                if cnt == k:
                    return n // x
            x -= 1

        return -1
    # leetcode submit region end(Prohibit modification and deletion)
