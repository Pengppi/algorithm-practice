"""
Title: 2654.Minimum Number of Operations to Make All Array Elements Equal to 1
Title Slug: minimumNumberOfOperationsToMakeAllArrayElementsEqualTo1
Author: Neo
Date: 2025-11-12 12:40:11
"""
from math import gcd
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        if gcd(*nums) > 1:
            return -1
        n = len(nums)
        cnt1 = nums.count(1)
        if cnt1 > 0:
            return n - cnt1

        min_op = n
        for i in range(n):
            g = 0
            for j in range(i, n):
                g = gcd(g, nums[j])
                if g == 1:
                    min_op = min(min_op, j - i)

        return min_op + n - 1

# leetcode submit region end(Prohibit modification and deletion)
