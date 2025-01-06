"""
Title: 3219.切蛋糕的最小总开销 II
Title Slug: minimumCostForCuttingCakeIi
Author: Neo
Date: 2024-12-31 12:43:56
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumCost(self, m: int, n: int, horizontalCut: List[int], verticalCut: List[int]) -> int:
        horizontalCut.sort()
        verticalCut.sort()
        ans = i = j = 0
        while i < m - 1 or j < n - 1:
            if j == n - 1 or i < m - 1 and horizontalCut[i] < verticalCut[j]:
                ans += horizontalCut[i] * (n - j)
                i += 1
            else:
                ans += verticalCut[j] * (m - i)
                j += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
