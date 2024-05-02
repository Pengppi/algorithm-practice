"""
Title: 26.删除有序数组中的重复项
Title Slug: removeDuplicatesFromSortedArray
Author: Neo
Date: 2024-05-02 22:14:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        length = 0
        for i in range(len(nums)):
            if i == 0 or nums[i] != nums[i - 1]:
                nums[length] = nums[i]
                length += 1
        return length
# leetcode submit region end(Prohibit modification and deletion)
