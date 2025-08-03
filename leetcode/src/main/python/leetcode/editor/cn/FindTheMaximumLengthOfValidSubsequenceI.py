"""
Title: 3201.Find the Maximum Length of Valid Subsequence I
Title Slug: findTheMaximumLengthOfValidSubsequenceI
Author: Neo
Date: 2025-07-16 12:35:54
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        return self.maximunLength(nums, 2)

    def maximunLength(self, nums: List[int], k: int) -> int:
        f = [[0] * k for _ in range(k)]
        for num in nums:
            x = num % k
            for y, fxy in enumerate(f[x]):
                f[y][x] = max(f[y][x], fxy + 1)
        return max(map(max, f))
# leetcode submit region end(Prohibit modification and deletion)
