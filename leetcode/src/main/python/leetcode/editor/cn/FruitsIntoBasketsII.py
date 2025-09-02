"""
Title: 3477.Fruits Into Baskets II
Title Slug: fruitsIntoBasketsIi
Author: Neo
Date: 2025-08-05 18:35:03
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numOfUnplacedFruits(self, fruits: List[int], baskets: List[int]) -> int:
        for fruit in fruits:
            i = 0
            while i < len(baskets) and baskets[i] < fruit:
                i += 1
            if i <len(baskets):
                del baskets[i]
        return len(baskets)
# leetcode submit region end(Prohibit modification and deletion)
