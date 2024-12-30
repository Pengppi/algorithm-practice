"""
Title: 1366.通过投票对团队排名
Title Slug: rankTeamsByVotes
Author: Neo
Date: 2024-12-29 16:49:47
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        n = len(votes[0])
        mp = defaultdict(lambda: [0] * n)
        for vote in votes:
            for i, c in enumerate(vote):
                mp[c][i] -= 1
        return ''.join(sorted(mp, key=lambda c: (mp[c], c)))

# leetcode submit region end(Prohibit modification and deletion)
