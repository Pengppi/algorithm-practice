"""
Title: 1749.任意子数组和的绝对值的最大值
Title Slug: maximumAbsoluteSumOfAnySubarray
Author: Neo
Date: 2024-06-29 01:28:21
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        n = len(nums)
        f = [[0, 0] for _ in range(n)]
        f[0][0] = f[0][1] = nums[0]
        ans = abs(nums[0])
        for i, x in enumerate(nums[1:], 1):
            f[i][0] = max(f[i - 1][0] + x, x)
            f[i][1] = min(f[i - 1][1] + x, x)
            ans = max(ans, abs(f[i][0]), abs(f[i][1]))
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().maxAbsoluteSum([-3, -5, -3, -2, -6, 3, 10, -10, -8, -3, 0, 10, 3, -5, 8, 7, -9, -9, 5, -8])
