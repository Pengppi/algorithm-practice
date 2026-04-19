"""
Title: 2515.Shortest Distance to Target String in a Circular Array
Title Slug: shortestDistanceToTargetStringInACircularArray
Author: Neo
Date: 2026-04-15 14:59:58
"""

from typing import List

# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        ans = n

        for i, c in enumerate(words):
            if c != target:
                continue
            d = abs(i - startIndex)
            ans = min(ans, d, n - d)

        return ans if ans < n else -1

# leetcode submit region end(Prohibit modification and deletion)
