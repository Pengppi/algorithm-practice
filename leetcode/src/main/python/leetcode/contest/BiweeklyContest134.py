from cmath import inf
from typing import List


class Solution:
    def numberOfAlternatingGroups(self, colors: List[int]) -> int:
        n = len(colors)
        i = n
        ans = 0
        while i < 2 * n:
            l = (i - 1) % n
            r = (i + 1) % n
            m = i % n
            if colors[l] != colors[m] and colors[r] != colors[m]:
                ans += 1
            i += 1
        return ans

    def maximumPoints(self, enemyEnergies: List[int], currentEnergy: int) -> int:
        mn = min(enemyEnergies)
        s = sum(enemyEnergies) - mn
        if mn > currentEnergy:
            return 0
        else:
            return (s + currentEnergy) // mn

    def numberOfAlternatingGroups(self, colors: List[int], k: int) -> int:
        n = len(colors)
        ans = 0
        i = 0
        j = 0
        while j < n + k - 1 and i < n:
            while j < n + k - 1 and colors[j % n] != colors[(j - 1) % n]:
                if j - i + 1 >= k:
                    ans += 1
                j += 1
            i = j
            j += 1
        return ans


