"""
Title: 2799.统计完全子数组的数目
Title Slug: countCompleteSubarraysInAnArray
Author: Neo
Date: 2025-04-24 14:16:40
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        st = set(nums)
        mp = defaultdict(int)
        ans = 0
        l = 0
        n = len(nums)
        for r, x in enumerate(nums):
            mp[x] += 1
            while len(mp) == len(st):
                ans += n - r
                mp[nums[l]] -= 1
                if mp[nums[l]] == 0:
                    del mp[nums[l]]
                l += 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
