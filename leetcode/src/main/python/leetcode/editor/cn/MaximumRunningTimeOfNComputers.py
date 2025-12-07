"""
Title: 2141.Maximum Running Time of N Computers
Title Slug: maximumRunningTimeOfNComputers
Author: Neo
Date: 2025-12-01 18:03:10
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        left, right = 0, sum(batteries) // n
        ans = 0
        while left <= right:
            mid = (left + right) >> 1
            tot = 0
            for cap in batteries:
                tot += min(cap, mid)
            if tot >= n * mid:
                ans = mid
                left = mid + 1
            else:
                right = mid - 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
