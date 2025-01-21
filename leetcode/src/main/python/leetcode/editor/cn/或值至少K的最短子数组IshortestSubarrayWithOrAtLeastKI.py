"""
Title: 3095.或值至少 K 的最短子数组 I
Title Slug: shortestSubarrayWithOrAtLeastKI
Author: Neo
Date: 2025-01-16 12:45:15
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        ans = inf
        for i, x in enumerate(nums):
            if x >= k:
                return 1
            j = i - 1
            while j >= 0 and nums[j] | x != nums[j]:
                nums[j] |= x
                if nums[j] >= k:
                    ans = min(ans, i - j + 1)
                j -= 1
        return -1 if ans == inf else ans
# leetcode submit region end(Prohibit modification and deletion)
