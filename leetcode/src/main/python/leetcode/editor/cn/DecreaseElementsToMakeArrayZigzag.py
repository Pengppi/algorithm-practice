"""
Title: 1144.Decrease Elements To Make Array Zigzag
Title Slug: decreaseElementsToMakeArrayZigzag
Author: Neo
Date: 2025-10-19 14:53:03
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def movesToMakeZigzag(self, nums: List[int]) -> int:
        n = len(nums)
        ans = [0] * 2
        for i, x in enumerate(nums):
            l = nums[i - 1] if i > 0 else inf
            r = nums[i + 1] if i + 1 < n else inf
            ans[i & 1] += max(0, x - min(l, r) + 1)
        return min(ans)

        # leetcode submit region end(Prohibit modification and deletion)
