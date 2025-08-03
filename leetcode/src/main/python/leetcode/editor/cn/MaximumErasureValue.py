"""
Title: 1695.Maximum Erasure Value
Title Slug: maximumErasureValue
Author: Neo
Date: 2025-07-22 10:08:38
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        mp = defaultdict(lambda: -1)
        ans = l = cur = 0
        n = len(nums)
        s = [0] * (n + 1)
        for i, x in enumerate(nums):
            s[i + 1] = s[i] + x
            if mp[x] >= l:
                cur -= s[mp[x] + 1] - s[l]
                l = mp[x] + 1
            cur += x
            ans = max(ans, cur)
            mp[x] = i

        return ans

# leetcode submit region end(Prohibit modification and deletion)
