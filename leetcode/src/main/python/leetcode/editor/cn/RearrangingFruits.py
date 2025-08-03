"""
Title: 2561.Rearranging Fruits
Title Slug: rearrangingFruits
Author: Neo
Date: 2025-08-02 17:17:27
"""
from cmath import inf
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCost(self, basket1: List[int], basket2: List[int]) -> int:
        cnt = defaultdict(int)
        for x, y in zip(basket1, basket2):
            cnt[x] += 1
            cnt[y] -= 1

        arr = []
        for x, c in cnt.items():
            if c & 1:
                return -1
            arr.extend([x] * (abs(c) // 2))

        arr.sort()
        mn = min(cnt)

        return sum(min(x, mn * 2) for x in arr[:len(arr) // 2])

# leetcode submit region end(Prohibit modification and deletion)
