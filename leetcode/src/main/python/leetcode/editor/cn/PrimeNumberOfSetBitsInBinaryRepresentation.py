"""
Title: 762.Prime Number of Set Bits in Binary Representation
Title Slug: primeNumberOfSetBitsInBinaryRepresentation
Author: Neo
Date: 2026-02-21 11:49:13
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:

        def isPrime(x: int) -> bool:
            if x <= 1:
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

        ans = 0
        for num in range(left, right + 1):
            ans += 1 if isPrime(num.bit_count()) else 0
        return ans

# leetcode submit region end(Prohibit modification and deletion)
