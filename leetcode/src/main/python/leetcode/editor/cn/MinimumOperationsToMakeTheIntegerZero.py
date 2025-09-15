"""
Title: 2749.Minimum Operations to Make the Integer Zero
Title Slug: minimumOperationsToMakeTheIntegerZero
Author: Neo
Date: 2025-09-05 12:44:55
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def makeTheIntegerZero(self, num1: int, num2: int) -> int:
        if num2 > num1:
            return -1
        num = num1 - num2
        for i in range(1, 60):
            # num 下限为 i 个 2 的 0 次方
            if num >= i >= num.bit_count():
                return i
            num -= num2
        return -1

    # leetcode submit region end(Prohibit modification and deletion)
