"""
Title: 3314.Construct the Minimum Bitwise Array I
Title Slug: constructTheMinimumBitwiseArrayI
Author: Neo
Date: 2026-01-20 12:29:05
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
