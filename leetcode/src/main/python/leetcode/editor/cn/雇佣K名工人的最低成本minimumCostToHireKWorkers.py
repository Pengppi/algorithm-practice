"""
Title: 857.雇佣 K 名工人的最低成本
Title Slug: minimumCostToHireKWorkers
Author: Neo
Date: 2024-05-02 16:55:40
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        pairs = sorted(zip(quality, wage), key=lambda x: x[1] / x[0])
        h = [-q for q, _ in pairs[:k]]
        heapq.heapify(h)
        sum_q = -sum(h)
        ans = sum_q * pairs[k - 1][1] / pairs[k - 1][0]
        for q, w in pairs[k:]:
            if q < -h[0]:
                sum_q += heapq.heapreplace(h, -q) + q
                ans = min(ans, sum_q * w / q)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
