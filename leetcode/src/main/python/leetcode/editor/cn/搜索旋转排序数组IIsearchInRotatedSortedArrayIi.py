"""
Title: 81.搜索旋转排序数组 II
Title Slug: searchInRotatedSortedArrayIi
Author: Neo
Date: 2025-02-01 10:34:34
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        def isLeft(i):
            mid = nums[i]
            if mid > nums[r]:
                return nums[r] < target <= mid
            else:
                return target > nums[r] or mid >= target

        l, r = -1, len(nums) - 1

        while l + 1 < r:
            m = (l + r) >> 1
            if nums[m] == nums[r]:
                r -= 1
            elif isLeft(m):
                r = m
            else:
                l = m
        return nums[r] == target

# leetcode submit region end(Prohibit modification and deletion)
