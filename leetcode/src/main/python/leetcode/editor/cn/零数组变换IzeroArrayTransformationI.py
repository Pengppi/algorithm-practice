"""
Title: 3355.零数组变换 I
Title Slug: zeroArrayTransformationI
Author: Neo
Date: 2025-05-20 23:50:07
"""
from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        n = len(nums)
        dif = [0] * (n + 1)
        for l, r in queries:
            dif[l] += 1
            dif[r + 1] -= 1
        for x, sum_dif in zip(nums, accumulate(dif)):
            if x > sum_dif:
                return False
        return True

# leetcode submit region end(Prohibit modification and deletion)
