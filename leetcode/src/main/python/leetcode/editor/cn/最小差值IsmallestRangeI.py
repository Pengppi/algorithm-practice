"""
Title: 908.最小差值 I
Title Slug: smallestRangeI
Author: Neo
Date: 2024-10-20 12:25:30
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestRangeI(self, nums: List[int], k: int) -> int:
        mx, mn = max(nums), min(nums)
        return max(0, mx - mn - 2 * k)

# leetcode submit region end(Prohibit modification and deletion)
