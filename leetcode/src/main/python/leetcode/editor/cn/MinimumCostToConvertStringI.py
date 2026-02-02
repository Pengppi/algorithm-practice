"""
Title: 2976.Minimum Cost to Convert String I
Title Slug: minimumCostToConvertStringI
Author: Neo
Date: 2026-01-29 09:45:27
"""
from cmath import inf
from math import cos
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minimumCost(self, source: str, target: str, original: List[str],
                    changed: List[str], cost: List[int]) -> int:

        if source == target:
            return 0
        f = [[inf] * 26 for _ in range(26)]
        for i in range(26):
            f[i][i] = 0
        for i, (u, v) in enumerate(zip(original, changed)):
            f[ord(u) - 97][ord(v) - 97] = min(f[ord(u) - 97][ord(v) - 97],
                                              cost[i])
        for k in range(26):
            for x in range(26):
                if f[x][k] == inf:
                    continue
                for y in range(26):
                    f[x][y] = min(f[x][y], f[x][k] + f[k][y])

        ans = 0
        for s, t in zip(source, target):
            a, b = ord(s) - 97, ord(t) - 97
            if f[a][b] == inf:
                return -1
            ans += f[a][b]

        return ans


# leetcode submit region end(Prohibit modification and deletion)
