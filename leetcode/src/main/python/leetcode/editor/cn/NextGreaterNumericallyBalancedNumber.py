"""
Title: 2048.Next Greater Numerically Balanced Number
Title Slug: nextGreaterNumericallyBalancedNumber
Author: Neo
Date: 2025-10-24 21:51:25
"""
import bisect
from collections import defaultdict

# leetcode submit region begin(Prohibit modification and deletion)
MX = 1224444


class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        def isValid(x: int) -> bool:
            cnt = [0] * 10
            while x:
                cnt[x % 10] += 1
                x //= 10

            for i in range(10):
                if cnt[i] and i != cnt[i]:
                    return False
            return True

        for i in range(n + 1, MX + 1):
            if isValid(i):
                return i
        return -1

    # leetcode submit region end(Prohibit modification and deletion)


Solution().nextBeautifulNumber(1)
