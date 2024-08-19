"""
Title: 3151.特殊数组 I
Title Slug: specialArrayI
Author: Neo
Date: 2024-08-13 12:28:38
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        f = nums[0] & 1
        for i, x in enumerate(nums):
            t = x & 1
            if t != f:
                return False
            f ^= 1
        return True
# leetcode submit region end(Prohibit modification and deletion)
