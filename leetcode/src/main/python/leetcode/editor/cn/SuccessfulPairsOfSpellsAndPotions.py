"""
Title: 2300.Successful Pairs of Spells and Potions
Title Slug: successfulPairsOfSpellsAndPotions
Author: Neo
Date: 2025-10-08 11:46:16
"""
import bisect
import math
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        n, m = len(spells), len(potions)
        ans = [0] * n

        for i, s in enumerate(spells):
            x = math.ceil(success / s)
            k = bisect.bisect_left(potions, x=x)
            ans[i] = m - k
        return ans

# leetcode submit region end(Prohibit modification and deletion)
