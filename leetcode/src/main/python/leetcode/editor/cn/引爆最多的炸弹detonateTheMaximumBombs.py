"""
Title: 2101.引爆最多的炸弹
Title Slug: detonateTheMaximumBombs
Author: Neo
Date: 2024-07-22 12:16:52
"""
import math
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        n = len(bombs)

        def getDist(i: int, j: int) -> float:
            x1, y1, _ = bombs[i]
            x2, y2, _ = bombs[j]
            return math.dist([x1, y1], [x2, y2])

        def dfs(i: int) -> int:
            vis[i] = True
            res = 1
            for j in range(n):
                if vis[j]:
                    continue
                if getDist(i, j) <= bombs[i][2]:
                    res += dfs(j)
            return res

        ans = 0
        for i, bomb in enumerate(bombs):
            vis = [False] * n
            ans = max(ans, dfs(i))

        return ans

# leetcode submit region end(Prohibit modification and deletion)
