"""
Title: 575.分糖果
Title Slug: distributeCandies
Author: Neo
Date: 2024-06-02 17:04:42
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def distributeCandies(self, candyType: List[int]) -> int:
        n, type_cnt = len(candyType), len(set(candyType))
        return min(n // 2, type_cnt)
# leetcode submit region end(Prohibit modification and deletion)
