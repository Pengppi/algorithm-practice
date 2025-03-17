"""
Title: 2012.数组美丽值求和
Title Slug: sumOfBeautyInTheArray
Author: Neo
Date: 2025-03-11 12:29:01
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumOfBeauties(self, nums: List[int]) -> int:
        n = len(nums)
        mn = [nums[-1]] * n
        for i in range(n - 2, 0, -1):
            mn[i] = min(mn[i + 1], nums[i + 1])

        mx = nums[0]
        ans = 0
        for i in range(1, n - 1):
            mx = max(mx, nums[i - 1])
            if mx < nums[i] < mn[i]:
                ans += 2
            elif nums[i - 1] < nums[i] < nums[i + 1]:
                ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
