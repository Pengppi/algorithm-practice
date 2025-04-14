"""
Title: 3375.使数组的值全部为 K 的最少操作次数
Title Slug: minimumOperationsToMakeArrayValuesEqualToK
Author: Neo
Date: 2025-04-09 12:36:47
"""
import bisect
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        nums = sorted(set(nums))
        if nums[0] < k:
            return -1
        n = len(nums)
        j = bisect.bisect_right(nums, k)
        return n - j


# leetcode submit region end(Prohibit modification and deletion)
Solution().minOperations([1], 1)
