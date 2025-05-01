"""
Title: 2845.统计趣味子数组的数目
Title Slug: countOfInterestingSubarrays
Author: Neo
Date: 2025-04-25 10:19:55
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        n = len(nums)
        mp = defaultdict(int)
        mp[0] = 1
        s = 0
        ans = 0
        for i in range(n):
            nums[i] = 1 if nums[i] % modulo == k else 0
            s += nums[i]
            ans += mp[(s - k) % modulo]
            mp[s % modulo] += 1
        return ans

    # leetcode submit region end(Prohibit modification and deletion)
