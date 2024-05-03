"""
Title: 486.预测赢家
Title Slug: predictTheWinner
Author: Neo
Date: 2024-05-03 21:25:43
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        @cache
        def totalSum(start, end):
            if start > end: return 0
            s1 = nums[start] - totalSum(start + 1, end)
            s2 = nums[end] - totalSum(start, end - 1)
            return max(s1, s2)

        return totalSum(0, len(nums) - 1) >= 0
# leetcode submit region end(Prohibit modification and deletion)
