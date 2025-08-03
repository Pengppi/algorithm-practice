"""
Title: 3480.Maximize Subarrays After Removing One Conflicting Pair
Title Slug: maximizeSubarraysAfterRemovingOneConflictingPair
Author: Neo
Date: 2025-07-26 10:20:12
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxSubarrays(self, n: int, conflictingPairs: List[List[int]]) -> int:
        g = [[] for _ in range(n + 1)]
        for a, b in conflictingPairs:
            if a > b:
                a, b = b, a
            g[a].append(b)

        rm_dif = [0] * (n + 2)
        ans = 0
        b = [n + 1, n + 1]

        for i in range(n, 0, -1):
            b = sorted(b + g[i])[:2]
            ans += b[0] - i
            rm_dif[b[0]] += b[1] - b[0]
        return ans + max(rm_dif)
# leetcode submit region end(Prohibit modification and deletion)
