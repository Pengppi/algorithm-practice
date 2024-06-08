"""
Title: 3040.相同分数的最大操作数目 II
Title Slug: maximumNumberOfOperationsWithTheSameScoreIi
Author: Neo
Date: 2024-06-08 11:26:25
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        n = len(nums)

        @cache
        def maxOperation(l: int, r: int, score: int) -> int:
            if l >= r:
                return 0
            res = 0
            if nums[l] + nums[l + 1] == score:
                res = 1 + maxOperation(l + 2, r, score)
            if nums[r] + nums[r - 1] == score:
                res = max(res, 1 + maxOperation(l, r - 2, score))
            if nums[l] + nums[r] == score:
                res = max(res, 1 + maxOperation(l + 1, r - 1, score))
            return res

        return max(maxOperation(2, n - 1, sum(nums[:2])), maxOperation(0, n - 3, sum(nums[-2:])),
                   maxOperation(1, n - 2, nums[0] + nums[n - 1])) + 1
# leetcode submit region end(Prohibit modification and deletion)
