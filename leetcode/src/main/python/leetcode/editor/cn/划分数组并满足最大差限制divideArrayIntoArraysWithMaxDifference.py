"""
Title: 2966.划分数组并满足最大差限制
Title Slug: divideArrayIntoArraysWithMaxDifference
Author: Neo
Date: 2025-06-18 12:27:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        n = len(nums)
        nums.sort()
        ans = []
        for i in range(0, n, 3):
            if nums[i + 2] - nums[i] > k:
                return []
            ans += [nums[i:i + 3]]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
