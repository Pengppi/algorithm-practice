"""
Title: 1124.Longest Well-Performing Interval
Title Slug: longestWellPerformingInterval
Author: Neo
Date: 2026-01-01 16:01:44
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def longestWPI(self, hours: List[int]) -> int:
        ans = 0
        score = 0
        seen = {0: -1}
        for i, h in enumerate(hours):
            score += 1 if h > 8 else -1
            if score > 0:
                ans = max(ans, i + 1)
            elif score - 1 in seen:
                ans = max(ans, i - seen[score - 1])
            if score not in seen:
                seen[score] = i
        return ans


# leetcode submit region end(Prohibit modification and deletion)
