"""
Title: 3097.或值至少为 K 的最短子数组 II
Title Slug: shortestSubarrayWithOrAtLeastKIi
Author: Neo
Date: 2025-01-17 12:31:47
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

        return ans if ans < inf else -1

# leetcode submit region end(Prohibit modification and deletion)
