"""
Title: 190.Reverse Bits
Title Slug: reverseBits
Author: Neo
Date: 2026-02-16 10:39:12
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseBits(self, n: int) -> int:
        s = bin(n)[2:].zfill(32)
        return int(s[::-1],2)
# leetcode submit region end(Prohibit modification and deletion)
