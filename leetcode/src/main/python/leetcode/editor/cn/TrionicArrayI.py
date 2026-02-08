"""
Title: 3637.Trionic Array I
Title Slug: trionicArrayI
Author: Neo
Date: 2026-02-03 12:31:15
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        if nums[0] >= nums[1]:  # 一开始必须是递增的
            return False
        cnt = 1
        for i in range(2, len(nums)):
            if nums[i - 1] == nums[i]:
                return False
            if (nums[i - 2] < nums[i - 1]) != (nums[i - 1] < nums[i]):
                cnt += 1
        return cnt == 3  # 一定是增减增



# leetcode submit region end(Prohibit modification and deletion)
