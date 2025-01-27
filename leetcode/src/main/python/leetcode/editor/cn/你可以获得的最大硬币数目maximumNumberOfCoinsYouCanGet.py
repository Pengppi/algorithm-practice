"""
Title: 1561.你可以获得的最大硬币数目
Title Slug: maximumNumberOfCoinsYouCanGet
Author: Neo
Date: 2025-01-22 12:54:46
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        return sum(x for i, x in enumerate(sorted(piles, reverse=True)[:len(piles) // 3 * 2]) if i & 1)
# leetcode submit region end(Prohibit modification and deletion)
