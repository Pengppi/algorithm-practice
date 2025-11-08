"""
Title: 3289.The Two Sneaky Numbers of Digitville
Title Slug: theTwoSneakyNumbersOfDigitville
Author: Neo
Date: 2025-10-31 12:36:10
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getSneakyNumbers(self, nums: List[int]) -> List[int]:
        duplicated_nums = []
        nums.sort()
        for i, num in enumerate(nums[1:], 1):
            if num == nums[i - 1]:
                duplicated_nums.append(num)
                if len(duplicated_nums) == 2:
                    return duplicated_nums
        return []

# leetcode submit region end(Prohibit modification and deletion)
