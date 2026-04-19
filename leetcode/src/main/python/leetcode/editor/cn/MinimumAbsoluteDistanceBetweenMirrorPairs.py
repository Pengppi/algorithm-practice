"""
Title: 3761.Minimum Absolute Distance Between Mirror Pairs
Title Slug: minimumAbsoluteDistanceBetweenMirrorPairs
Author: Neo
Date: 2026-04-17 14:48:13
"""

from cmath import inf
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minMirrorPairDistance(self, nums: List[int]) -> int:

        def reverse(num: int) -> int:
            x = num
            t = 0
            while x > 0:
                t = t * 10 + x % 10
                x //= 10
            return t

        ans = inf
        mp = defaultdict(int)
        for i, num in enumerate(nums[::-1]):
            rev = reverse(num)
            if rev in mp:
                ans = min(ans, i - mp[rev])
            mp[num] = i

        return ans if ans < inf else -1  # pyright: ignore[reportReturnType]


# leetcode submit region end(Prohibit modification and deletion)
