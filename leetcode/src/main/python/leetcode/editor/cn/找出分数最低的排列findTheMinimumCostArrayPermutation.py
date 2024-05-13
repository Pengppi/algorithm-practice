"""
Title: 3149.找出分数最低的排列
Title Slug: findTheMinimumCostArrayPermutation
Author: Neo
Date: 2024-05-13 22:25:28
"""
from functools import cache
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findPermutation(self, nums: List[int]) -> List[int]:
        n = len(nums)

        @cache
        def dfs(i: int, j: int) -> int:
            if i == (1 << n) - 1:
                return abs(j - nums[0])
            res = inf
            for k in range(1, n):
                if i & (1 << k) == 0:
                    res = min(res, dfs(i | (1 << k), k) + abs(j - nums[k]))
            return res

        ans = []

        def get_ans(i: int, j: int):
            ans.append(j)
            if i == (1 << n) - 1:
                return
            res = dfs(i, j)
            for k in range(1, n):
                if i & (1 << k) == 0 and dfs(i | (1 << k), k) + abs(j - nums[k]) == res:
                    get_ans(i | (1 << k), k)
                    break

        get_ans(1, 0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
