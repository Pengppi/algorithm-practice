"""
Title: 3464.Maximize the Distance Between Points on a Square
Title Slug: maximizeTheDistanceBetweenPointsOnASquare
Author: Neo
Date: 2026-04-25 11:05:24
"""

from bisect import bisect_left
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxDistance(self, side: int, points: List[List[int]], k: int) -> int:
        arr = []
        for x, y in points:
            if x == 0:
                arr.append(y)
            elif y == side:
                arr.append(side + x)
            elif x == side:
                arr.append(side * 3 - y)
            else:
                arr.append(side * 4 - x)
        arr.sort()

        def check(limit: int) -> bool:
            for start in arr[:-k + 1]:
                end = start + side * 4 - limit
                cur = start
                for _ in range(k - 1):
                    idx = bisect_left(arr, cur + limit)
                    if idx == len(arr) or arr[idx] > end:
                        cur = -1
                        break
                    cur = arr[idx]
                if cur >= 0:
                    return True
            return False

        lo, hi = 1, side * 4 // k + 1
        while lo + 1 < hi:
            m = (lo + hi) // 2
            if check(m):
                lo = m
            else:
                hi = m
        return lo

# leetcode submit region end(Prohibit modification and deletion)
