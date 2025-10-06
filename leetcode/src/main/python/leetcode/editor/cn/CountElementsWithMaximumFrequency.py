"""
Title: 3005.Count Elements With Maximum Frequency
Title Slug: countElementsWithMaximumFrequency
Author: Neo
Date: 2025-09-22 12:16:40
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq_cnt = Counter(nums)
        mx_freq = max(freq_cnt.values())

        return sum([freq for x, freq in freq_cnt.items() if freq == mx_freq])

# leetcode submit region end(Prohibit modification and deletion)
