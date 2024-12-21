"""
Title: 2717.半有序排列
Title Slug: semiOrderedPermutation
Author: Neo
Date: 2024-12-11 13:28:14
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def semiOrderedPermutation(self, nums: List[int]) -> int:
        n = len(nums)
        l = nums.index(1)
        r = nums.index(n)
        if l < r:
            return l + n - 1 - r
        else:
            return l + n - 1 - r - 1

    # leetcode submit region end(Prohibit modification and deletion)
