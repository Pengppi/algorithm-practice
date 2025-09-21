"""
Title: 2197.Replace Non-Coprime Numbers in Array
Title Slug: replaceNonCoprimeNumbersInArray
Author: Neo
Date: 2025-09-16 12:39:06
"""
import math
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def replaceNonCoprimes(self, nums: List[int]) -> List[int]:
        n = len(nums)
        for i in range(n - 2, -1, -1):
            a, b = nums[i], nums[i + 1]
            while math.gcd(a, b) > 1:
                a = math.lcm(a, b)
                nums.pop(i + 1)
                if i + 1 == len(nums):
                    break
                b = nums[i + 1]
            nums[i] = a
        return nums
# leetcode submit region end(Prohibit modification and deletion)

