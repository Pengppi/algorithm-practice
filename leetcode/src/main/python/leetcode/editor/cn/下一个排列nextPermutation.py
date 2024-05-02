"""
Title: 31.下一个排列
Title Slug: nextPermutation
Author: Neo
Date: 2024-05-02 22:18:51
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if n <= 1:
            return
        i = n - 2
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        if i >= 0:
            k = n - 1
            while k > i + 1 and nums[k] <= nums[i]:
                k -= 1
            nums[i], nums[k] = nums[k], nums[i]
        l, r = i + 1, n - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
# leetcode submit region end(Prohibit modification and deletion)
