"""
Title: 1984.Minimum Difference Between Highest and Lowest of K Scores
Title Slug: minimumDifferenceBetweenHighestAndLowestOfKScores
Author: Neo
Date: 2026-01-25 14:52:33
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:

        nums.sort()

        return min(nums[i] - nums[i - k + 1] for i in range(k - 1, len(nums)))

    # leetcode submit region end(Prohibit modification and deletion)
