"""
Title: 2894.分类求和并作差
Title Slug: divisibleAndNonDivisibleSumsDifference
Author: Neo
Date: 2025-05-27 23:46:52
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        tot = n * (n + 1) // 2
        num2 = sum(range(m, n + 1, m))
        num1 = tot - num2
        return num1 - num2
# leetcode submit region end(Prohibit modification and deletion)
