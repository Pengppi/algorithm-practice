"""
Title: LCR 007.三数之和
Title Slug: oneFGaJU
Author: Neo
Date: 2024-07-05 17:31:57
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        ans = []
        for i, num in enumerate(nums):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            r = n - 1
            t = -nums[i]
            for l in range(i + 1, n):
                if l > i + 1 and nums[l] == nums[l - 1]:
                    continue
                while l < r and nums[l] + nums[r] > t:
                    r -= 1
                if l == r:
                    break
                if nums[l] + nums[r] == t:
                    ans.append((nums[i], nums[l], nums[r]))
        return ans

        # leetcode submit region end(Prohibit modification and deletion)
