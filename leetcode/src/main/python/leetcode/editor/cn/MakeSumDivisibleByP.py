"""
Title: 1590.Make Sum Divisible by P
Title Slug: makeSumDivisibleByP
Author: Neo
Date: 2025-11-30 10:15:04
"""

# leetcode submit region begin(Prohibit modification and deletion)
from itertools import accumulate
from typing import DefaultDict, List


class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        n = len(nums)
        tot = sum(nums)
        if tot % p == 0:
            return 0

        ps = list(accumulate(nums))
        mp = DefaultDict(lambda: -n)
        ans = n
        for i, x in enumerate(ps):
            other = tot - x
            if x % p == 0:
                ans = min(ans, n - 1 - i)
            r = other % p
            if r == 0:
                ans = min(ans, i + 1, i - mp[0])
            else:
                ans = min(ans, i - mp[p - r])
            mp[x % p] = i
        return -1 if ans >= n else ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().minSubarray([3, 1, 3], 3)

print(8 % 3)
print(1 % 3)
