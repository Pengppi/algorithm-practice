"""
Title: 3634.Minimum Removals to Balance Array
Title Slug: minimumRemovalsToBalanceArray
Author: Neo
Date: 2026-02-06 15:35:40
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        l = r = 0  # noqa: E741
        ans = 0
        while r < n and ans < n - l:
            while r < n and nums[l] * k >= nums[r]:
                r += 1
            ans = max(ans, r - l)
            l += 1  # noqa: E741
        return n - ans

# leetcode submit region end(Prohibit modification and deletion)
