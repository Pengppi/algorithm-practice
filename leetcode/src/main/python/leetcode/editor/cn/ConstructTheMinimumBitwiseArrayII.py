"""
Title: 3315.Construct the Minimum Bitwise Array II
Title Slug: constructTheMinimumBitwiseArrayIi
Author: Neo
Date: 2026-01-21 16:59:10
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def minBitwiseArray(self, nums: List[int]) -> List[int]:
        for i, x in enumerate(nums):
            if x == 2:
                nums[i] = -1
            else:
                t = ~x
                nums[i] ^= (t & -t) >> 1
        return nums


# leetcode submit region end(Prohibit modification and deletion)
