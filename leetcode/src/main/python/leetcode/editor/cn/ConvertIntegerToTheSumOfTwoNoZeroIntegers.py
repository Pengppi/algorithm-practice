"""
Title: 1317.Convert Integer to the Sum of Two No-Zero Integers
Title Slug: convertIntegerToTheSumOfTwoNoZeroIntegers
Author: Neo
Date: 2025-09-08 12:28:30
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:
        def is_contain_zero(num: int) -> bool:
            return '0' in str(num)

        for x in range(1, n // 2 + 1):
            if is_contain_zero(x):
                continue
            y = n - x
            if is_contain_zero(y):
                continue
            return [x, y]
        return [-1, -1]

    # leetcode submit region end(Prohibit modification and deletion)
