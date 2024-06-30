"""
Title: 494.目标和
Title Slug: targetSum
Author: Neo
Date: 2024-06-30 12:18:41
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if sum(nums) < abs(target):
            return 0

        @cache
        def dfs(i: int, sum: int) -> int:
            if i == n:
                return 1 if sum == target else 0
            return dfs(i + 1, sum + nums[i]) + dfs(i + 1, sum - nums[i])

        return dfs(0, 0)
# leetcode submit region end(Prohibit modification and deletion)
