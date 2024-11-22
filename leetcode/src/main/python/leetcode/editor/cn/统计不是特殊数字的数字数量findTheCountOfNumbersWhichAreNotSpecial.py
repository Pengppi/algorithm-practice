"""
Title: 3233.统计不是特殊数字的数字数量
Title Slug: findTheCountOfNumbersWhichAreNotSpecial
Author: Neo
Date: 2024-11-22 12:57:22
"""
import math


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
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
# leetcode submit region end(Prohibit modification and deletion)
