"""
Title: 3623.Count Number of Trapezoids I
Title Slug: countNumberOfTrapezoidsI
Author: Neo
Date: 2025-12-02 12:12:41
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import Counter, defaultdict
from typing import List


class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        mod = 10 ** 9 + 7
        cnt = Counter(y for x, y in points)
        ans = s = 0
        for c in cnt.values():
            k = c * (c - 1) // 2
            ans += s * k
            ans %= mod
            s += k
        return ans

# leetcode submit region end(Prohibit modification and deletion)
