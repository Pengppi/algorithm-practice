"""
Title: 2931.购买物品的最大开销
Title Slug: maximumSpendingAfterBuyingItems
Author: Neo
Date: 2024-12-12 13:05:51
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSpending(self, values: List[List[int]]) -> int:
        m, n = len(values), len(values[0])
        q = []
        for i in range(m):
            q.append((values[i][n - 1], i, n - 1))
        heapq.heapify(q)
        ans = 0
        for i in range(1, m * n + 1):
            w, x, y = heapq.heappop(q)
            ans += i * w
            if y > 0:
                heapq.heappush(q, (values[x][y - 1], x, y - 1))
        return ans

# leetcode submit region end(Prohibit modification and deletion)
