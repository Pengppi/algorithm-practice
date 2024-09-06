"""
Title: 2860.让所有学生保持开心的分组方法数
Title Slug: happyStudents
Author: Neo
Date: 2024-09-04 12:44:59
"""
from itertools import pairwise
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countWays(self, nums: List[int]) -> int:
        n = len(nums)
        nums.sort()
        ans = 1 if nums[0] > 0 else 0
        for i, x in enumerate(nums, 1):
            if i < n and x < i < nums[i]:
                ans += 1
        return ans + 1

# leetcode submit region end(Prohibit modification and deletion)
