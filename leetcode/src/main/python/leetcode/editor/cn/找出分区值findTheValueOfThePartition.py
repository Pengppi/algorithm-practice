"""
Title: 2740.找出分区值
Title Slug: findTheValueOfThePartition
Author: Neo
Date: 2024-07-26 12:16:20
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findValueOfPartition(self, nums: List[int]) -> int:
        nums.sort()
        ans = min(nums[i] - nums[i - 1] for i in range(1, len(nums)))
        return ans

# leetcode submit region end(Prohibit modification and deletion)
