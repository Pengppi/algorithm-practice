"""
Title: 342.Power of Four
Title Slug: powerOfFour
Author: Neo
Date: 2025-08-15 18:35:36
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n <= 0 or n.bit_count() != 1:
            return False
        lb = n & -n
        return lb.bit_length() & 1 == 1

# leetcode submit region end(Prohibit modification and deletion)
