"""
Title: 1705.吃苹果的最大数目
Title Slug: maximumNumberOfEatenApples
Author: Neo
Date: 2024-12-24 12:40:18
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def eatenApples(self, apples: List[int], days: List[int]) -> int:
        ans = i = 0
        q = []
        n = len(apples)
        while i < n or q:
            while q and q[0][0] <= i:
                heapq.heappop(q)
            if i < n and apples[i]:
                heapq.heappush(q, [i + days[i], apples[i]])
            if q:
                ans += 1
                q[0][1] -= 1
                if not q[0][1]:
                    heapq.heappop(q)
            i += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().eatenApples([2, 1, 1, 4, 5], [10, 10, 6, 4, 2])
