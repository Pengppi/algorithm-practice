"""
Title: 2786.访问数组中的位置使分数最大
Title Slug: visitArrayPositionsToMaximizeScore
Author: Neo
Date: 2024-06-14 10:50:33
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxScore(self, nums: List[int], x: int) -> int:
        @cache
        def dfs(i: int, j: int) -> int:
            if i == len(nums):
                return 0
            if nums[i] & 1 != j:
                return dfs(i + 1, j)
            return max(dfs(i + 1, j), dfs(i + 1, j ^ 1) - x) + nums[i]

        return dfs(0, nums[0] & 1)
# leetcode submit region end(Prohibit modification and deletion)
