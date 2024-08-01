"""
Title: 2844.生成特殊数字的最少操作
Title Slug: minimumOperationsToMakeASpecialNumber
Author: Neo
Date: 2024-07-25 23:37:10
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumOperations(self, num: str) -> int:
        n = len(num)

        def fun(t: str) -> int:
            i = num.rfind(t[1])
            if i <= 0:
                return n
            i = num.rfind(t[0], 0, i)
            return n if i < 0 else n - i - 2

        return min(n - ('0' in num), fun("00"), fun("50"), fun("25"), fun("75"))
# leetcode submit region end(Prohibit modification and deletion)
