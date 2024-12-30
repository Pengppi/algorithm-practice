"""
Title: 3218.切蛋糕的最小总开销 I
Title Slug: minimumCostForCuttingCakeI
Author: Neo
Date: 2024-12-25 12:24:37
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minimumCost(self, m: int, n: int, horizontalCut: List[int], verticalCut: List[int]) -> int:
        horizontalCut.sort(reverse=True)
        verticalCut.sort(reverse=True)

        @cache
        def dfs(i: int, j: int) -> int:
            if i < m - 1 and j < n - 1:
                h = horizontalCut[i] * (j + 1)
                v = verticalCut[j] * (i + 1)
                return min(dfs(i + 1, j) + h, dfs(i, j + 1) + v)
            if i < m - 1:
                return sum(horizontalCut[i:]) * (j + 1)
            elif j < n - 1:
                return sum(verticalCut[j:]) * (i + 1)
            else:
                return 0

        return dfs(0, 0)
# leetcode submit region end(Prohibit modification and deletion)
