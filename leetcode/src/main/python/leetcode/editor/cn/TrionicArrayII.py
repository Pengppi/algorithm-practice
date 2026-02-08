"""
Title: 3640.Trionic Array II
Title Slug: trionicArrayIi
Author: Neo
Date: 2026-02-04 12:38:46
"""
from cmath import inf
from itertools import pairwise
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSumTrionic(self, nums: List[int]) -> int:
        ans = f1 = f2 = f3 = -inf
        for x, y in pairwise(nums):
            f3 = max(f3, f2) + y if x < y else -inf
            f2 = max(f2, f1) + y if x > y else -inf
            f1 = max(f1, x) + y if x < y else -inf
            ans = max(ans, f3)
        return ans




# leetcode submit region end(Prohibit modification and deletion)

