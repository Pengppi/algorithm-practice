"""
Title: 2341.Maximum Number of Pairs in Array
Title Slug: maximumNumberOfPairsInArray
Author: Neo
Date: 2026-01-01 15:45:32
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import Counter
from typing import List


class Solution:

    def numberOfPairs(self, nums: List[int]) -> List[int]:
        pairs = leftover = 0
        freq = Counter(nums)
        for k, v in freq.items():
            pairs += v // 2
            leftover += v % 2
        return [pairs, leftover]


# leetcode submit region end(Prohibit modification and deletion)
