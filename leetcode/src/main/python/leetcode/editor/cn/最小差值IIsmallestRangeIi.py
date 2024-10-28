"""
Title: 910.最小差值 II
Title Slug: smallestRangeIi
Author: Neo
Date: 2024-10-21 12:32:59
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestRangeII(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        ans = nums[-1] - nums[0]
        for i in range(0, n - 1):
            mx = max(nums[-1] - k, nums[i] + k)
            mn = min(nums[0] + k, nums[i + 1] - k)
            ans = min(ans, mx - mn)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
