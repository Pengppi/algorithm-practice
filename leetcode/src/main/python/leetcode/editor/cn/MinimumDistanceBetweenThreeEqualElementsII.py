"""
Title: 3741.Minimum Distance Between Three Equal Elements II
Title Slug: minimumDistanceBetweenThreeEqualElementsIi
Author: Neo
Date: 2026-04-11 12:37:01
"""
from collections import defaultdict
from math import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        mp = defaultdict(list)
        for i, x in enumerate(nums):
            mp[x].append(i)

        ans = inf
        for ids in mp.values():
            if len(ids) < 3:
                continue
            for i in range(len(ids) - 2):
                a, b, c = ids[i], ids[i + 1], ids[i + 2]
                dist = b - a + c - b + c - a
                ans = min(ans, dist)

        return ans if ans != inf else -1
# leetcode submit region end(Prohibit modification and deletion)

