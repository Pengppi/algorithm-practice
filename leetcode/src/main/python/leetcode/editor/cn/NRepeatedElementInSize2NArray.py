"""
Title: 961.N-Repeated Element in Size 2N Array
Title Slug: nRepeatedElementInSize2nArray
Author: Neo
Date: 2026-01-02 16:29:41
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def repeatedNTimes(self, nums: List[int]) -> int:
        ans = vote = 0
        for i in range(1, len(nums)):
            x = nums[i]
            if x == nums[0]:
                return nums[0]
            if vote == 0:
                ans, vote = x, 1
            else:
                vote += 1 if x == ans else -1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
