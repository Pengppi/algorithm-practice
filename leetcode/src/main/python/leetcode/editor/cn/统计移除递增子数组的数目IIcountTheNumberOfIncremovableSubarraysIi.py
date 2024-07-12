"""
Title: 2972.统计移除递增子数组的数目 II
Title Slug: countTheNumberOfIncremovableSubarraysIi
Author: Neo
Date: 2024-07-11 12:41:34
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def incremovableSubarrayCount(self, nums: List[int]) -> int:
        i, n = 0, len(nums)
        while i < n - 1 and nums[i] < nums[i + 1]:
            i += 1
        if i == n - 1:
            return n * (n + 1) // 2
        ans = i + 2
        j = n - 1
        while j == n - 1 or nums[j] < nums[j + 1]:
            while i >= 0 and nums[i] >= nums[j]:
                i -= 1
            ans += i + 2
            j -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
