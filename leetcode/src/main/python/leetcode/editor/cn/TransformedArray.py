"""
Title: 3379.Transformed Array
Title Slug: transformedArray
Author: Neo
Date: 2026-02-05 22:20:54
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        n = len(nums)

        def getMovedValue(i: int) -> int:
            j = (i + nums[i]) % n
            if j < 0:
                j = n - j
            return nums[j]

        ans = [0] * n

        for i, x in enumerate(nums):
            if x != 0:
                x = getMovedValue(i)
            ans[i] = x

        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().constructTransformedArray([3, -2, 1, 1])
