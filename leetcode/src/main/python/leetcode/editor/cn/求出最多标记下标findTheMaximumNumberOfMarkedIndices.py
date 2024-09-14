"""
Title: 2576.求出最多标记下标
Title Slug: findTheMaximumNumberOfMarkedIndices
Author: Neo
Date: 2024-09-12 12:34:52
"""
from bisect import bisect_left, bisect_right
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        l = 0
        for x in nums[(n + 1) // 2:]:
            if 2 * nums[l] <= x:
                l += 1
        return l * 2
# leetcode submit region end(Prohibit modification and deletion)
