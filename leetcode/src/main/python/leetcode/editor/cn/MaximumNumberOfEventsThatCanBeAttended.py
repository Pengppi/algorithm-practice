"""
Title: 1353.Maximum Number of Events That Can Be Attended
Title Slug: maximumNumberOfEventsThatCanBeAttended
Author: Neo
Date: 2025-07-07 20:23:15
"""
import heapq
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        mx = max(x for _, x in events)
        g = [[] for _ in range(mx + 1)]
        for u, v in events:
            g[u].append(v)

        ans = 0
        h = []
        for i, times in enumerate(g):
            while h and h[0] < i:
                heapq.heappop(h)
            for t in times:
                heapq.heappush(h, t)
            if h:
                heapq.heappop(h)
                ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
