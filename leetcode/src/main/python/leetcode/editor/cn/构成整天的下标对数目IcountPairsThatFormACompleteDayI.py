"""
Title: 3184.构成整天的下标对数目 I
Title Slug: countPairsThatFormACompleteDayI
Author: Neo
Date: 2024-10-22 13:28:41
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        mp = defaultdict(int)
        ans = 0
        for x in hours:
            x %= 24
            ans += mp[(24 - x) % 24]
            mp[x] += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
