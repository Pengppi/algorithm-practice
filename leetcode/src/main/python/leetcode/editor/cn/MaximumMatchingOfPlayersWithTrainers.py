"""
Title: 2410.Maximum Matching of Players With Trainers
Title Slug: maximumMatchingOfPlayersWithTrainers
Author: Neo
Date: 2025-07-13 14:31:09
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def matchPlayersAndTrainers(self, players: List[int], trainers: List[int]) -> int:
        players.sort()
        trainers.sort()
        i = j = 0
        while i < len(players) and j< len(trainers):
            if players[i] <= trainers[j]:
                i += 1
                j += 1
            else:
                j += 1
        return i



        
# leetcode submit region end(Prohibit modification and deletion)

