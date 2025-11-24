"""
Title: 717.1-bit and 2-bit Characters
Title Slug: oneBitAnd2BitCharacters
Author: Neo
Date: 2025-11-18 12:53:03
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        last = -1
        while bits:
            x = bits[0]
            if x == 0:
                last = 1
                del bits[0]
            else:
                last = 2
                del bits[0:2]

        return last == 1
# leetcode submit region end(Prohibit modification and deletion)
