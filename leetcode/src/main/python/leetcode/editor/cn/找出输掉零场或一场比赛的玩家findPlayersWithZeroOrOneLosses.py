"""
Title: 2225.找出输掉零场或一场比赛的玩家
Title Slug: findPlayersWithZeroOrOneLosses
Author: Neo
Date: 2024-05-22 11:59:29
"""
from collections import defaultdict, Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        players = set(x for m in matches for x in m)
        loss_cnt = Counter(loser for _, loser in matches)
        return [sorted(x for x in players if x not in loss_cnt),
                sorted(x for x, c in loss_cnt.items() if c == 1)]

        # leetcode submit region end(Prohibit modification and deletion)
