"""
Title: 231.Power of Two
Title Slug: powerOfTwo
Author: Neo
Date: 2025-08-09 16:17:55
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n <= 0:
            return False

        return n.bit_count() == 1
# leetcode submit region end(Prohibit modification and deletion)
