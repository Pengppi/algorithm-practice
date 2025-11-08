"""
Title: 1578.Minimum Time to Make Rope Colorful
Title Slug: minimumTimeToMakeRopeColorful
Author: Neo
Date: 2025-11-03 12:37:04
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        ans = 0
        n = len(colors)
        i = 0
        while i < n:
            j = i + 1
            while j < n and colors[i] == colors[j]:
                j += 1
            if j > i + 1:
                ans += sum(neededTime[i:j]) - max(neededTime[i:j])
            i = j

        return ans

# leetcode submit region end(Prohibit modification and deletion)
