"""
Title: 2383.Minimum Hours of Training to Win a Competition
Title Slug: minimumHoursOfTrainingToWinACompetition
Author: Neo
Date: 2025-07-31 14:24:24
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minNumberOfHours(self, initialEnergy: int, initialExperience: int, energy: List[int], experience: List[int]) -> int:
        n = len(energy)
        ans = 0
        for en, xp in zip(energy, experience):
            if initialEnergy <= en:
                ans += en + 1 - initialEnergy
                initialEnergy = en + 1
            initialEnergy -= en
            if initialExperience <= xp:
                ans += xp + 1 - initialExperience
                initialExperience = xp + 1
            initialExperience += xp
        return ans

# leetcode submit region end(Prohibit modification and deletion)
