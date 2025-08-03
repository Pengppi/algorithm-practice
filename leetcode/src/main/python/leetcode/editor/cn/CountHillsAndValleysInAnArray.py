"""
Title: 2210.Count Hills and Valleys in an Array
Title Slug: countHillsAndValleysInAnArray
Author: Neo
Date: 2025-07-27 15:58:31
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        idx = 1
        for j in range(1, len(nums)):
            if nums[j] != nums[idx - 1]:
                nums[idx] = nums[j]
                idx += 1

        ans = 0
        for i in range(1, idx - 1):
            a, b, c = nums[i - 1], nums[i], nums[i + 1]
            if (a < b > c) or (a > b < c):
                ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
