"""
Title: 1009.Complement of Base 10 Integer
Title Slug: complementOfBase10Integer
Author: Neo
Date: 2026-03-11 18:27:30
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def bitwiseComplement(self, n: int) -> int:

        return ((1 << n.bit_length()) - 1) ^ n if n else 1
# leetcode submit region end(Prohibit modification and deletion)
