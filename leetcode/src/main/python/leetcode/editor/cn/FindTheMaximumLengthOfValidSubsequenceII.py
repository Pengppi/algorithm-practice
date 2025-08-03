"""
Title: 3202.Find the Maximum Length of Valid Subsequence II
Title Slug: findTheMaximumLengthOfValidSubsequenceIi
Author: Neo
Date: 2025-07-17 20:20:49
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        f = [[0] * k for _ in range(k)]

        for num in nums:
            x = num % k
            for y, fxy in enumerate(f[x]):
                f[y][x] = max(fxy + 1, f[y][x])

        return max(map(max, f))
# leetcode submit region end(Prohibit modification and deletion)
