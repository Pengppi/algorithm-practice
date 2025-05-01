"""
Title: 2302.统计得分小于 K 的子数组数目
Title Slug: countSubarraysWithScoreLessThanK
Author: Neo
Date: 2025-04-28 12:18:26
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        ans = 0
        l = 0
        s = 0
        for r, x in enumerate(nums):
            s += x
            while s * (r - l + 1) >= k:
                s -= nums[l]
                l += 1
            ans += r - l + 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
