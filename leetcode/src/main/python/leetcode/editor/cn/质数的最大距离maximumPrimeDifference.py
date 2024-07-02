"""
Title: 3115.质数的最大距离
Title Slug: maximumPrimeDifference
Author: Neo
Date: 2024-07-02 12:47:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        def isPrime(x: int) -> bool:
            if x < 2:
                return False
            if x <= 3:
                return True
            if x % 2 == 0 or x % 3 == 0:
                return False
            i = 5
            while i * i <= x:
                if x % i == 0 or x % (i + 2) == 0:
                    return False
                i += 6
            return True

        l, r = 0, len(nums) - 1
        while l <= r and not isPrime(nums[l]):
            l += 1
        while l < r and not isPrime(nums[r]):
            r -= 1
        return r - l
    # leetcode submit region end(Prohibit modification and deletion)
