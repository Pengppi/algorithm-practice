"""
Title: 1184.公交站间的距离
Title Slug: distanceBetweenBusStops
Author: Neo
Date: 2024-09-16 13:42:18
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        n = len(distance)
        tot = sum(distance)
        i = start
        ans = 0
        while i != destination:
            ans += distance[i]
            i = (i + 1) % n
        return min(ans, tot - ans)
    # leetcode submit region end(Prohibit modification and deletion)
