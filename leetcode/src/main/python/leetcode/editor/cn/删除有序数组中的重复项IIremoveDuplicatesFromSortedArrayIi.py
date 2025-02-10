"""
Title: 80.删除有序数组中的重复项 II
Title Slug: removeDuplicatesFromSortedArrayIi
Author: Neo
Date: 2025-02-09 21:07:11
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        x = 2
        for i in range(2, len(nums)):
            if nums[i] != nums[x - 2]:
                nums[x] = nums[i]
                x += 1

        return x

# leetcode submit region end(Prohibit modification and deletion)
