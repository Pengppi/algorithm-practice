"""
Title: 312.戳气球
Title Slug: burstBalloons
Author: Neo
Date: 2024-06-09 08:23:42
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        nums = [1] + nums + [1]

        @cache
        def dfs(l: int, r: int) -> int:
            if l + 1 >= r:
                return 0
            res = 0
            for k in range(l + 1, r):
                res = max(res, dfs(l, k) + dfs(k, r) + nums[k] * nums[l] * nums[r])
            return res

        return dfs(0, n + 1)

# leetcode submit region end(Prohibit modification and deletion)
