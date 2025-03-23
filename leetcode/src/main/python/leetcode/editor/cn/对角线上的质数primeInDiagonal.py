"""
Title: 2614.对角线上的质数
Title Slug: primeInDiagonal
Author: Neo
Date: 2025-03-18 12:53:34
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def diagonalPrime(self, nums: List[List[int]]) -> int:
        def isPrime(x):
            if x == 1:
                return False
            for i in range(2, int(x ** 0.5) + 1):
                if x % i == 0:
                    return False
            return True

        ans = 0
        for i in range(len(nums)):
            if isPrime(nums[i][i]):
                ans = max(ans, nums[i][i])
            if isPrime(nums[i][-i - 1]):
                ans = max(ans, nums[i][-i - 1])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
