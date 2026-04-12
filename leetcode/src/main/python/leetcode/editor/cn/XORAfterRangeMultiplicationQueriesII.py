"""
Title: 3655.XOR After Range Multiplication Queries II
Title Slug: xorAfterRangeMultiplicationQueriesIi
Author: Neo
Date: 2026-04-09 12:41:35
"""

from functools import reduce
from math import isqrt
from operator import xor
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        mod = 10**9 + 7
        n = len(nums)
        B = isqrt(len(queries))
        diff: List[List[int]] = [None] * B  # pyright: ignore[reportAssignmentType]

        for l, r, k, v in queries:  # noqa: E741
            if k < B:
                if not diff[k]:
                    diff[k] = [1] * (n + k)
                diff[k][l] = diff[k][l] * v % mod
                r = r - (r - l) % k
                diff[k][r + k] = diff[k][r + k] * pow(v, -1, mod) % mod

            else:
                for i in range(l, r + 1, k):
                    nums[i] = nums[i] * v % mod

        for k, d in enumerate(diff):
            if not d:
                continue
            for start in range(k):
                multiple = 1
                for i in range(start, n, k):
                    multiple = multiple * d[i] % mod
                    nums[i] = nums[i] * multiple % mod

        return reduce(xor, nums)  # pyright: ignore[reportAny]


# leetcode submit region end(Prohibit modification and deletion)
