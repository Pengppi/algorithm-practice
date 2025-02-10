"""
Title: 922.按奇偶排序数组 II
Title Slug: sortArrayByParityIi
Author: Neo
Date: 2025-02-04 17:19:37
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortArrayByParityII(self, nums: List[int]) -> List[int]:
        def swap(i, j):
            nums[i], nums[j] = nums[j], nums[i]

        n = len(nums)
        j = 1
        for i in range(0, n, 2):
            if nums[i] & 1 == 0:
                continue
            while j < n and nums[j] & 1:
                j += 2
            swap(i, j)
        return nums

    # leetcode submit region end(Prohibit modification and deletion)
