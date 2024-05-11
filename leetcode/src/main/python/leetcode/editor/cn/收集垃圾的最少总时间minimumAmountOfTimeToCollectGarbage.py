"""
Title: 2391.收集垃圾的最少总时间
Title Slug: minimumAmountOfTimeToCollectGarbage
Author: Neo
Date: 2024-05-11 00:38:12
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        ans, sum_travel_time = 0, 0
        time_map = defaultdict(int)
        for i, g in enumerate(garbage):
            ans += len(g)
            sum_travel_time += travel[i - 1] if i != 0 else 0
            for c in g:
                ans += sum_travel_time - time_map[c]
                time_map[c] = sum_travel_time
        return ans

# leetcode submit region end(Prohibit modification and deletion)
