"""
Title: 2555.两个线段获得的最多奖品
Title Slug: maximizeWinFromTwoSegments
Author: Neo
Date: 2024-09-11 13:18:31
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximizeWin(self, prizePositions: List[int], k: int) -> int:
        n = len(prizePositions)
        if 2 * k + 1 >= prizePositions[-1] - prizePositions[0]:
            return n
        ans = 0
        l = 0
        cnt = [0] * (n + 1)
        for r, x in enumerate(prizePositions):
            while prizePositions[r] - prizePositions[l] > k:
                l += 1
            cur = r - l + 1
            ans = max(ans, cnt[l] + cur)
            cnt[r + 1] = max(cnt[r], cur)
        return ans
    # leetcode submit region end(Prohibit modification and deletion)
