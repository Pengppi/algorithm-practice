"""
Title: 1751.Maximum Number of Events That Can Be Attended II
Title Slug: maximumNumberOfEventsThatCanBeAttendedIi
Author: Neo
Date: 2025-07-08 21:35:17
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        if k == 1:
            return max(e[2] for e in events)
        events.sort(key=lambda e: e[1])
        n = len(events)
        dp = [[0] * (k + 1) for _ in range(n + 1)]
        for i, (s, e, v) in enumerate(events):
            p = bisect.bisect_left(events, s, hi=n - 1, key=lambda e: e[1])
            for j in range(1, k + 1):
                dp[i + 1][j] = max(dp[i][j], dp[p][j - 1] + v)
        return dp[n][k]

# leetcode submit region end(Prohibit modification and deletion)
