import math
from typing import List


class Solution:
    def canAliceWin(self, nums: List[int]) -> bool:
        sums = [0] * 3
        for i, num in enumerate(nums):
            t = num
            l = 0
            while t > 0:
                t //= 10
                l += 1
            sums[l - 1] += num
        print(sums)
        if sums[0] > sums[1] + sums[2] or sums[1] > sums[0] + sums[2]:
            return True
        return False

    def nonSpecialCount(self, l: int, r: int) -> int:
        def is_prime(n: int) -> bool:
            if n <= 1:
                return False
            if n <= 3:
                return True
            if n % 2 == 0 or n % 3 == 0:
                return False
            i = 5
            while i * i <= n:
                if n % i == 0 or n % (i + 2) == 0:
                    return False
                i += 6
            return True

        ans = r - l + 1
        l_sqrt, r_sqrt = math.sqrt(l), math.sqrt(r)
        l = math.ceil(l_sqrt)
        r = math.floor(r_sqrt)

        return ans - sum(1 for i in range(l, r + 1) if is_prime(i))


