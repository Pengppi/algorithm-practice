"""
Title: 2595.奇偶位数
Title Slug: numberOfEvenAndOddBits
Author: Neo
Date: 2025-02-20 12:46:56
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def evenOddBit(self, n: int) -> List[int]:
        ans = [0, 0]
        i = 0
        while n:
            if n & 1:
                ans[i % 2] += 1
            n >>= 1
            i += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
