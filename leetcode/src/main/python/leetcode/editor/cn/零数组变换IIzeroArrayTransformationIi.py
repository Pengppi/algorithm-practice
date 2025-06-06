"""
Title: 3356.零数组变换 II
Title Slug: zeroArrayTransformationIi
Author: Neo
Date: 2025-05-21 12:52:38
"""
from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minZeroArray(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)

        def check(k):
            diff = [0] * (n + 1)
            for i in range(k):
                l, r, v = queries[i]
                diff[l] += v
                diff[r + 1] -= v

            for x, sum_diff in zip(nums, accumulate(diff)):
                if x > sum_diff:
                    return False
            return True

        l = -1
        r = len(queries) + 1
        while l + 1 < r:
            mid = (l + r) >> 1
            if check(mid):
                r = mid
            else:
                l = mid
        return r if r <= len(queries) else -1

# leetcode submit region end(Prohibit modification and deletion)
