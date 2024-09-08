"""
Title: 977.有序数组的平方
Title Slug: squaresOfASortedArray
Author: Neo
Date: 2024-09-08 12:19:14
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        l, r = 0, n - 1
        for idx in range(n - 1, -1, -1):
            x = nums[l] ** 2
            y = nums[r] ** 2
            if x > y:
                ans[idx] = x
                l += 1
            else:
                ans[idx] = y
                r -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
