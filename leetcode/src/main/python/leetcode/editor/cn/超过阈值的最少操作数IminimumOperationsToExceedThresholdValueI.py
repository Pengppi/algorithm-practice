"""
Title: 3065.超过阈值的最少操作数 I
Title Slug: minimumOperationsToExceedThresholdValueI
Author: Neo
Date: 2025-01-14 13:20:41
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        return sum([1 for x in nums if x < k])
# leetcode submit region end(Prohibit modification and deletion)
