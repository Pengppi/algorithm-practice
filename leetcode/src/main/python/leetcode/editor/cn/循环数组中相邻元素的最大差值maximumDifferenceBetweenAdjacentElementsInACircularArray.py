"""
Title: 3423.循环数组中相邻元素的最大差值
Title Slug: maximumDifferenceBetweenAdjacentElementsInACircularArray
Author: Neo
Date: 2025-06-27 19:00:11
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxAdjacentDistance(self, nums: List[int]) -> int:
        ans = abs(nums[0] - nums[-1])
        for i in range(1, len(nums)):
            ans = max(ans, abs(nums[i] - nums[i - 1]))

        return ans

# leetcode submit region end(Prohibit modification and deletion)
