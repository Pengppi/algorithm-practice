"""
Title: 3495.Minimum Operations to Make Array Elements Zero
Title Slug: minimumOperationsToMakeArrayElementsZero
Author: Neo
Date: 2025-09-06 11:22:25
"""
import math
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, queries: List[List[int]]) -> int:
        def get_ops_cnt(x: int) -> int:
            m = x.bit_length()
            res = sum((i + 1) // 2 << (i - 1) for i in range(1, m))
            return res + (m + 1) // 2 * (x + 1 - (1 << m >> 1))

        return sum((get_ops_cnt(r) - get_ops_cnt(l - 1) + 1) // 2 for l, r in queries)
# leetcode submit region end(Prohibit modification and deletion)
