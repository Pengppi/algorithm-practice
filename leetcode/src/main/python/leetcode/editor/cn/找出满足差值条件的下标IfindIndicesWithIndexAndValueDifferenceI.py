"""
Title: 2903.找出满足差值条件的下标 I
Title Slug: findIndicesWithIndexAndValueDifferenceI
Author: Neo
Date: 2024-05-25 00:05:41
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findIndices(self, nums: List[int], indexDifference: int, valueDifference: int) -> List[int]:
        n = len(nums)
        for l in range(n - indexDifference):
            for r in range(l + indexDifference, n):
                if abs(nums[l] - nums[r]) >= valueDifference:
                    return [l, r]
        return [-1, -1]
# leetcode submit region end(Prohibit modification and deletion)
 