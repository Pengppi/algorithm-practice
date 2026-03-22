"""
Title: 1223.Dice Roll Simulation
Title Slug: diceRollSimulation
Author: Neo
Date: 2026-03-20 20:16:32
"""

# leetcode submit region begin(Prohibit modification and deletion)
from functools import cache
from typing import List


class Solution:
    def dieSimulator(self, n: int, rollMax: List[int]) -> int:
        mod = 10**9 + 7

        @cache
        def dfs(pos: int, last: int, cnt: int) -> int:
            if pos == n:
                return 1

            res = 0
            for d in range(1, 7):
                if d == last and rollMax[d - 1] == cnt:
                    continue
                res += dfs(pos + 1, d, 1 if d != last else cnt + 1)
                res %= mod
            return res

        return dfs(0, 0, 0)


# leetcode submit region end(Prohibit modification and deletion)
