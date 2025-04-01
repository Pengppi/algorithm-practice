"""
Title: 2360.图中的最长环
Title Slug: longestCycleInAGraph
Author: Neo
Date: 2025-03-29 17:23:07
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        ans = -1
        n = len(edges)
        vis = [0] * n
        cur = 1
        for i in range(n):
            start = cur
            x = i
            while x != -1 and vis[x] == 0:
                vis[x] = cur
                cur += 1
                x = edges[x]
            if x != -1 and vis[x] >= start:
                ans = max(ans, cur - vis[x])

        return ans

# leetcode submit region end(Prohibit modification and deletion)
