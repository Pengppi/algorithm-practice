"""
Title: 2275.按位与结果大于零的最长组合
Title Slug: largestCombinationWithBitwiseAndGreaterThanZero
Author: Neo
Date: 2025-01-12 18:34:59
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        bitCnt = [0] * 32
        for num in candidates:
            for i in range(32):
                bitCnt[i] += (num >> i) & 1

        return max(bitCnt)

# leetcode submit region end(Prohibit modification and deletion)
