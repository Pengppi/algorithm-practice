"""
Title: 1526.Minimum Number of Increments on Subarrays to Form a Target Array
Title Slug: minimumNumberOfIncrementsOnSubarraysToFormATargetArray
Author: Neo
Date: 2025-10-30 12:37:20
"""
from itertools import pairwise
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minNumberOperations(self, target: List[int]) -> int:
        ans = target[0]
        for x, y in pairwise(target):
            ans += max(0, y - x)
        return ans

            # leetcode submit region end(Prohibit modification and deletion)


Solution().minNumberOperations([1, 2, 3, 2, 1])
