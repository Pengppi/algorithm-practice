"""
Title: 3349.Adjacent Increasing Subarrays Detection I
Title Slug: adjacentIncreasingSubarraysDetectionI
Author: Neo
Date: 2025-10-14 12:44:53
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        n = len(nums)

        def isValid(i: int) -> bool:
            last = nums[i]
            for j in range(i + 1, i + k):
                if nums[j] <= last:
                    return False
                last = nums[j]
            return True

        for i in range(0, n - 2 * k + 1):
            if isValid(i) and isValid(i + k):
                return True

        return False

# leetcode submit region end(Prohibit modification and deletion)
