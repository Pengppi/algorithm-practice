"""
Title: 756.Pyramid Transition Matrix
Title Slug: pyramidTransitionMatrix
Author: Neo
Date: 2025-12-29 18:30:16
"""
from typing import List
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        mp = defaultdict(list)
        for a in allowed:
            mp[a[0:2]].append(a[2])

        def dfs(next: str, cur: str, index: int) -> bool:
            if len(cur) == 2:
                return len(mp[cur]) > 0

            if index == len(cur) - 1:
                return dfs("", next, 0)

            if not mp[cur[index:index + 2]]:
                return False

            return any(
                dfs(next + c, cur, index + 1)
                for c in mp[cur[index:index + 2]])

        return dfs("", bottom, 0)


# leetcode submit region end(Prohibit modification and deletion)

Solution().pyramidTransition("BCD", ["BCC", "CDE", "CEA", "FFF"])
