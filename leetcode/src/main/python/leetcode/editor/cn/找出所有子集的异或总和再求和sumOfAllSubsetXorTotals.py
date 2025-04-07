"""
Title: 1863.找出所有子集的异或总和再求和
Title Slug: sumOfAllSubsetXorTotals
Author: Neo
Date: 2025-04-05 23:41:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        ans = 0

        def back_track(i, xor):
            nonlocal ans
            ans += xor
            if i == len(nums):
                return
            for i in range(i, len(nums)):
                back_track(i + 1, xor ^ nums[i])

        back_track(0, 0)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
