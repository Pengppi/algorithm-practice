"""
Title: 3583.Count Special Triplets
Title Slug: countSpecialTriplets
Author: Neo
Date: 2025-12-09 12:22:03
"""

# leetcode submit region begin(Prohibit modification and deletion)
from bisect import bisect_left
from collections import defaultdict
from typing import List


class Solution:

    def specialTriplets(self, nums: List[int]) -> int:
        mod = 10**9 + 7
        mp = defaultdict(list)
        for i, x in enumerate(nums):
            mp[x].append(i)
        n = len(nums)
        ans = 0
        for j in range(1, n - 1):
            t = nums[j] * 2
            if not mp[t]:
                continue
            idx = bisect_left(mp[t], j)
            l = idx
            r = len(mp[t]) - l
            if t == 0:
                r -= 1

            ans += l * r
            ans %= mod
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().specialTriplets([0, 1, 0, 0])
