"""
Title: 2357.Make Array Zero by Subtracting Equal Amounts
Title Slug: makeArrayZeroBySubtractingEqualAmounts
Author: Neo
Date: 2025-11-14 20:18:41
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        nums.sort()
        ans = 0
        factor = 0
        while nums:
            if nums[0] > factor:
                factor += nums[0] - factor
                ans += 1
            del nums[0]
        return ans
        # leetcode submit region end(Prohibit modification and deletion)
