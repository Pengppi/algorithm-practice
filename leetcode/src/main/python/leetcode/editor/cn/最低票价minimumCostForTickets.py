"""
Title: 983.最低票价
Title Slug: minimumCostForTickets
Author: Neo
Date: 2024-10-01 18:48:48
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = days[-1] + 1
        st = set(days)
        f = [0] * n
        for i in range(1, n):
            if i not in st:
                f[i] = f[i - 1]
                continue
            f[i] = min(f[i - 1] + costs[0], f[max(i - 7, 0)] + costs[1], f[max(i - 30, 0)] + costs[2])
        return f[-1]
# leetcode submit region end(Prohibit modification and deletion)
