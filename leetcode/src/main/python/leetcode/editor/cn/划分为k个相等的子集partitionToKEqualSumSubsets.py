"""
Title: 698.划分为k个相等的子集
Title Slug: partitionToKEqualSumSubsets
Author: Neo
Date: 2024-08-25 12:26:53
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        tot = sum(nums)
        if tot % k != 0:
            return False
        target = tot // k
        nums.sort()
        if nums[-1] > target:
            return False
        n = len(nums)

        @cache
        def dfs(mask: int, t: int):
            if mask == (1 << n) - 1:
                return True

            for i in range(n):
                if nums[i] + t > target:
                    break
                if (mask >> i) & 1 == 0 and dfs(mask | (1 << i), (t + nums[i]) % target):
                    return True
            return False

        return dfs(0, 0)
# leetcode submit region end(Prohibit modification and deletion)
