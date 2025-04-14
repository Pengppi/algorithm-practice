"""
Title: 416.分割等和子集
Title Slug: partitionEqualSubsetSum
Author: Neo
Date: 2025-04-07 11:11:59
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        tot = sum(nums)
        if tot & 1:
            return False
        target = tot >> 1
        n = len(nums)

        @cache
        def dfs(i, s):
            if s == target:
                return True
            if s > target or i >= n:
                return False
            return dfs(i + 1, s) or dfs(i + 1, s + nums[i])

        return dfs(0, 0)

# leetcode submit region end(Prohibit modification and deletion)
