"""
Title: LCR 003.比特位计数
Title Slug: w3tCBm
Author: Neo
Date: 2024-05-15 14:58:17
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countBits(self, n: int) -> List[int]:
        return [i.bit_count() for i in range(n + 1)]

# leetcode submit region end(Prohibit modification and deletion)
