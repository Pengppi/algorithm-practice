"""
Title: 2779.数组的最大美丽值
Title Slug: maximumBeautyOfAnArrayAfterApplyingOperation
Author: Neo
Date: 2024-06-15 12:04:46
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        ans, l = 0, 0
        for r in range(n):
            while nums[r] - nums[l] > k * 2:
                l += 1
            ans = max(ans, r - l + 1)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
