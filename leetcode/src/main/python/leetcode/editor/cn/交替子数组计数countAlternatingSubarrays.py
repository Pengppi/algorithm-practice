"""
Title: 3101.交替子数组计数
Title Slug: countAlternatingSubarrays
Author: Neo
Date: 2024-07-06 18:34:49
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        ans, last = 0, 0
        for i, x in enumerate(nums):
            if i > 0 and x != nums[i - 1]:
                ans += last
                last += 1
            else:
                last = 1
            ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
