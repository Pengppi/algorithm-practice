"""
Title: 1235.规划兼职工作
Title Slug: maximumProfitInJobScheduling
Author: Neo
Date: 2024-05-04 11:19:15
"""
from bisect import bisect_right, bisect_left
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        jobs = sorted(zip(startTime, endTime, profit), key=lambda x: x[1])
        n = len(startTime)
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            k = bisect_right(jobs, jobs[i - 1][0], hi=i, key=lambda x: x[1])
            dp[i] = max(dp[i - 1], dp[k] + jobs[i - 1][2])
        return dp[n]

# leetcode submit region end(Prohibit modification and deletion)
