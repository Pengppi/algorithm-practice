"""
Title: 3238.求出胜利玩家的数目
Title Slug: findTheNumberOfWinningPlayers
Author: Neo
Date: 2024-11-23 17:19:40
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def winningPlayerCount(self, n: int, pick: List[List[int]]) -> int:
        cnt = [[0 for _ in range(11)] for _ in range(n)]
        ans = set()
        for x, y in pick:
            cnt[x][y] += 1
            if cnt[x][y] > x:
                ans.add(x)
        return len(ans)
# leetcode submit region end(Prohibit modification and deletion)
