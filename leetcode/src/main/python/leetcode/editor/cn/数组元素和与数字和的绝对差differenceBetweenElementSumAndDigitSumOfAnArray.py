"""
Title: 2535.数组元素和与数字和的绝对差
Title Slug: differenceBetweenElementSumAndDigitSumOfAnArray
Author: Neo
Date: 2024-09-26 16:30:37
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def differenceOfSum(self, nums: List[int]) -> int:
        s1, s2 = 0, 0
        for x in nums:
            s1 += x
            while x > 0:
                s2 += x % 10
                x //= 10
        return abs(s1 - s2)

# leetcode submit region end(Prohibit modification and deletion)
