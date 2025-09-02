"""
Title: 2348.Number of Zero-Filled Subarrays
Title Slug: numberOfZeroFilledSubarrays
Author: Neo
Date: 2025-08-19 18:32:20
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def zeroFilledSubarray(self, nums: List[int]) -> int:
        ans = 0
        i = 0
        n = len(nums)
        while i < n:
            j = i
            while j < n and nums[j] == 0:
                j += 1
            ans += (j - i + 1) * (j - i) // 2
            i = j + 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
