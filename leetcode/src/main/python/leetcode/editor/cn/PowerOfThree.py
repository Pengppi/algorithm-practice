"""
Title: 326.Power of Three
Title Slug: powerOfThree
Author: Neo
Date: 2025-08-13 12:31:21
"""
import bisect


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n == 1:
            return True
        elif n < 3:
            return False

        k = bisect.bisect_left(range(20), x=n, key=lambda x: 3**x)
        return pow(3, k) == n
# leetcode submit region end(Prohibit modification and deletion)
