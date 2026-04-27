"""
Title: 2615.Sum of Distances
Title Slug: sumOfDistances
Author: Neo
Date: 2026-04-23 12:16:55
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        mp = defaultdict(list)
        for i, x in enumerate(nums):
            mp[x].append(i)

        for arr in mp.values():
            sz = len(arr)
            if sz <= 1:
                continue
            tot = sum(arr)

            left_s = 0
            for i, x in enumerate(arr):
                ans[x] = i * x - left_s
                right_s = tot - left_s
                ans[x] += right_s - (sz - i) * x
                left_s += x
        return ans
# leetcode submit region end(Prohibit modification and deletion)
