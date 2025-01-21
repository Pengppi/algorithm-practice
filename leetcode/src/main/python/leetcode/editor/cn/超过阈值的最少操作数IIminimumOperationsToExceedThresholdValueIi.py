"""
Title: 3066.超过阈值的最少操作数 II
Title Slug: minimumOperationsToExceedThresholdValueIi
Author: Neo
Date: 2025-01-15 12:37:32
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        ans = 0
        while len(nums) > 1 and nums[0] < k:
            x, y = heapq.heappop(nums), heapq.heappop(nums)
            heapq.heappush(nums, x * 2 + y)
            ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
