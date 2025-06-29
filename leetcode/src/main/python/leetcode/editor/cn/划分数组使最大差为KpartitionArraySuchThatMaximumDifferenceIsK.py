"""
Title: 2294.划分数组使最大差为 K
Title Slug: partitionArraySuchThatMaximumDifferenceIsK
Author: Neo
Date: 2025-06-19 22:07:58
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def partitionArray(self, nums: List[int], k: int) -> int:
        nums.sort()
        ans = 0
        l = 0
        for r, x in enumerate(nums):
            if x - nums[l] > k:
                l = r
                ans += 1
        ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
