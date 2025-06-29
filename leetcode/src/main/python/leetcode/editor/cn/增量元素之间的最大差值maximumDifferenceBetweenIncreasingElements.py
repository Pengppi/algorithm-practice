"""
Title: 2016.增量元素之间的最大差值
Title Slug: maximumDifferenceBetweenIncreasingElements
Author: Neo
Date: 2025-06-16 18:32:10
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        mn = nums[0]
        ans = -1
        for i in range(1, len(nums)):
            if nums[i] > mn:
                ans = max(ans, nums[i] - mn)
            else:
                mn = nums[i]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
