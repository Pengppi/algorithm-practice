"""
Title: 1615.最大网络秩
Title Slug: maximalNetworkRank
Author: Neo
Date: 2025-05-30 10:06:02
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        g = [[] for _ in range(n)]
        for a, b in roads:
            g[a].append(b)
            g[b].append(a)
        ans = 0
        for i in range(n):
            for j in range(i + 1, n):
                cnt = len(g[i]) + len(g[j])
                if j in g[i]:
                    cnt -= 1
                ans = max(ans, cnt)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
