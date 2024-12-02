"""
Title: 3250.单调数组对的数目 I
Title Slug: findTheCountOfMonotonicPairsI
Author: Neo
Date: 2024-11-28 12:27:05
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countOfPairs(self, nums: List[int]) -> int:
        mod = 10 ** 9 + 7
        n = len(nums)

        @cache
        def dfs(x: int, i: int, j: int):
            if x == n:
                return 1
            ij = i + j
            if ij > nums[x]:
                j -= ij - nums[x]
            else:
                i += nums[x] - ij
            res = 0
            while j >= 0:
                res += dfs(x + 1, i, j)
                res %= mod
                j -= 1
                i += 1
            return res

        return dfs(0, 0, nums[0])
# leetcode submit region end(Prohibit modification and deletion)
