"""
Title: 3494.Find the Minimum Amount of Time to Brew Potions
Title Slug: findTheMinimumAmountOfTimeToBrewPotions
Author: Neo
Date: 2025-10-09 09:22:01
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minTime(self, skill: List[int], mana: List[int]) -> int:
        n, m = len(skill), len(mana)
        last_finished = [0] * n
        for ma in mana:
            cur = 0
            for s, last in zip(skill, last_finished):
                cur = max(cur, last)
                cur += s * ma
            last_finished[-1] = cur
            for i in range(n - 2, -1, -1):
                last_finished[i] = last_finished[i + 1] - skill[i + 1] * ma

        return last_finished[-1]
    # leetcode submit region end(Prohibit modification and deletion)
