"""
Title: 1848.Minimum Distance to the Target Element
Title Slug: minimumDistanceToTheTargetElement
Author: Neo
Date: 2026-04-13 12:22:47
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        ans = inf
        for i, num in enumerate(nums):
            if num == target:
                ans = min(ans, abs(i - start))
        return ans
# leetcode submit region end(Prohibit modification and deletion)
