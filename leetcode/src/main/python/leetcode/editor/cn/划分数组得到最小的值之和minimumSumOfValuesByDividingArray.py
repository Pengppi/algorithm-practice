"""
Title: 3117.划分数组得到最小的值之和
Title Slug: minimumSumOfValuesByDividingArray
Author: Neo
Date: 2024-05-14 14:18:40
"""
from functools import cache
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumValueSum(self, nums: List[int], andValues: List[int]) -> int:
        n, m = len(nums), len(andValues)

        @cache
        def dfs(i: int, j: int, and_res: int) -> int:
            if i == n:
                return 0 if j == m else inf
            if j == m:
                return inf
            and_res &= nums[i]
            if and_res < andValues[j]:
                return inf
            res = dfs(i + 1, j, and_res)
            if and_res == andValues[j]:
                res = min(res, dfs(i + 1, j + 1, -1) + nums[i])
            return res

        ans = dfs(0, 0, -1)
        return ans if ans < inf else -1

    # leetcode submit region end(Prohibit modification and deletion)
