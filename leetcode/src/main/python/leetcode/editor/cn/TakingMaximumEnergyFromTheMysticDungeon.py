"""
Title: 3147.Taking Maximum Energy From the Mystic Dungeon
Title Slug: takingMaximumEnergyFromTheMysticDungeon
Author: Neo
Date: 2025-10-10 12:42:44
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumEnergy(self, energy: List[int], k: int) -> int:
        n = len(energy)
        f = [e for e in energy]
        for i in range(k, n):
            f[i] += max(0, f[i - k])

        return max(f[-k:])
# leetcode submit region end(Prohibit modification and deletion)
