from functools import cache
from typing import List


class Solution:
    def countKConstraintSubstrings(self, s: str, k: int) -> int:
        n = len(s)
        ans = 0
        z = 0
        o = 0
        l = 0
        for r in range(n):
            if s[r] == '1':
                o += 1
            else:
                z += 1
            while o > k and z > k:
                if s[l] == '1':
                    o -= 1
                else:
                    z -= 1
                l += 1
            ans += (r - l) + 1
        return ans

    def maxEnergyBoost(self, energyDrinkA: List[int], energyDrinkB: List[int]) -> int:
        n = len(energyDrinkA)

        @cache
        def dfs(step, f):
            if step >= n:
                return 0
            if f:
                return energyDrinkA[step] + max(dfs(step + 1, True), dfs(step + 2, False))
            else:
                return energyDrinkB[step] + max(dfs(step + 1, False), dfs(step + 2, True))

        return max(dfs(0, True), dfs(0, False))


