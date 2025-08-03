"""
Title: 2044.Count Number of Maximum Bitwise-OR Subsets
Title Slug: countNumberOfMaximumBitwiseOrSubsets
Author: Neo
Date: 2025-07-28 18:32:12
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        n = len(nums)

        @cache
        def dfs(x, cur, target):
            res = 0
            if cur == target:
                res += 1
            for i in range(x, n):
                tmp = cur
                cur |= nums[i]
                res += dfs(i + 1, cur, target)
                cur = tmp
            return res

        t = 0
        for num in nums:
            t |= num

        return dfs(0, 0, t)

# leetcode submit region end(Prohibit modification and deletion)
