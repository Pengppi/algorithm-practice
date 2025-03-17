"""
Title: 2588.统计美丽子数组数目
Title Slug: countTheNumberOfBeautifulSubarrays
Author: Neo
Date: 2025-03-06 12:41:41
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def beautifulSubarrays(self, nums: List[int]) -> int:
        mask = 0
        mp = defaultdict(int)
        ans = 0
        mp[0] = 1
        for i, num in enumerate(nums):
            mask ^= num
            ans += mp[mask]
            mp[mask] += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
