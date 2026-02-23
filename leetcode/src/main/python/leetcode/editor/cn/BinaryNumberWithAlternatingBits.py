"""
Title: 693.Binary Number with Alternating Bits
Title Slug: binaryNumberWithAlternatingBits
Author: Neo
Date: 2026-02-18 09:20:54
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        x = n ^ (n >> 1)
        return x & (x + 1) == 0
# leetcode submit region end(Prohibit modification and deletion)

