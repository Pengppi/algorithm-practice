"""
Title: 1979.找出数组的最大公约数
Title Slug: findGreatestCommonDivisorOfArray
Author: Neo
Date: 2024-05-03 20:46:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findGCD(self, nums: List[int]) -> int:
        def gcd(a: int, b: int) -> int:
            return gcd(b, a % b) if b > 0 else a

        return gcd(max(nums), min(nums))
# leetcode submit region end(Prohibit modification and deletion)
