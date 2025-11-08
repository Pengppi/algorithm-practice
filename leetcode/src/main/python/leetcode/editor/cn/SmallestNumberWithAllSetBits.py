"""
Title: 3370.Smallest Number With All Set Bits
Title Slug: smallestNumberWithAllSetBits
Author: Neo
Date: 2025-10-29 12:38:20
"""
import bisect


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestNumber(self, n: int) -> int:
        arr = [(1 << x) - 1 for x in range(1, 12)]
        k = bisect.bisect_left(arr, x=n)
        return arr[k]

# leetcode submit region end(Prohibit modification and deletion)
