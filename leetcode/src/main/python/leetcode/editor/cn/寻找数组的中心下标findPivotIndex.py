"""
Title: 724.寻找数组的中心下标
Title Slug: findPivotIndex
Author: Neo
Date: 2024-07-08 12:44:48
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        tot_sum = sum(nums)
        cur_sum = 0
        for i, num in enumerate(nums):
            if cur_sum == tot_sum - cur_sum - num:
                return i
            cur_sum += num
        return -1

# leetcode submit region end(Prohibit modification and deletion)
