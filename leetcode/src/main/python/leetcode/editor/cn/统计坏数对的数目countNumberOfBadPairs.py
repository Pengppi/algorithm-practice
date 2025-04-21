"""
Title: 2364.统计坏数对的数目
Title Slug: countNumberOfBadPairs
Author: Neo
Date: 2025-04-18 17:07:24
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countBadPairs(self, nums: List[int]) -> int:
        ans = 0
        mp = defaultdict(int)
        for i, x in enumerate(nums):
            d = x - i
            ans += i - mp[d]
            mp[d] += 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
