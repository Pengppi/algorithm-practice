"""
Title: 2176.统计数组中相等且可以被整除的数对
Title Slug: countEqualAndDivisiblePairsInAnArray
Author: Neo
Date: 2025-04-17 15:17:31
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        mp = defaultdict(list)
        ans = 0
        for i, x in enumerate(nums):
            for j in mp[x]:
                if i * j % k == 0:
                    ans += 1

            mp[x].append(i)

        return ans

# leetcode submit region end(Prohibit modification and deletion)
