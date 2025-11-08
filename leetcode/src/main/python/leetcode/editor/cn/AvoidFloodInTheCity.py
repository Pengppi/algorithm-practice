"""
Title: 1488.Avoid Flood in The City
Title Slug: avoidFloodInTheCity
Author: Neo
Date: 2025-10-07 09:26:06
"""
import bisect
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        ans = [-1] * n
        rains_mp = dict()
        dry = []
        for i, r in enumerate(rains):
            if r == 0:
                dry.append(i)
                ans[i] = 1
                continue
            if r in rains_mp:
                k = bisect.bisect_left(dry, x=rains_mp[r])
                if k >= len(dry):
                    return []
                d = dry[k]
                ans[d] = r
                del dry[k]
            rains_mp[r] = i
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().avoidFlood([1,0,2,0,3,0,2,0,0,0,1,2,3])
