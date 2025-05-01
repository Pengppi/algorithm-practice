"""
Title: 3392.统计符合条件长度为 3 的子数组数目
Title Slug: countSubarraysOfLengthThreeWithACondition
Author: Neo
Date: 2025-04-27 12:36:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(1,n-1):
            if (nums[i-1]+nums[i+1])*2 == nums[i]:
                ans += 1
        return ans

        
# leetcode submit region end(Prohibit modification and deletion)

