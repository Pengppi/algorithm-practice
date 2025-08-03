"""
Title: 2683.Neighboring Bitwise XOR
Title Slug: neighboringBitwiseXor
Author: Neo
Date: 2025-07-31 14:03:46
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        n = len(derived)
        og = [0] * n
        for i, x in enumerate(derived[:-1]):
            if x == 1:
                og[i + 1] = og[i] ^ 1
            else:
                og[i + 1] = og[i]
        return og[-1] ^ og[0] == derived[-1]


# leetcode submit region end(Prohibit modification and deletion)
