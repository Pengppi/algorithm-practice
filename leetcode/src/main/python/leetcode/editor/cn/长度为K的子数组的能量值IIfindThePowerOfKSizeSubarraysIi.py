"""
Title: 3255.长度为 K 的子数组的能量值 II
Title Slug: findThePowerOfKSizeSubarraysIi
Author: Neo
Date: 2024-11-07 12:46:06
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        ans = []
        n = len(nums)
        l = 0
        for r, x in enumerate(nums):
            if r > 0 and x != nums[r - 1] + 1:
                while l < r and l < n - k + 1:
                    ans.append(-1)
                    l += 1
            if r - l + 1 == k:
                ans.append(x)
                l += 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
