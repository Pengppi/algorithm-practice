"""
Title: 799.Champagne Tower
Title Slug: champagneTower
Author: Neo
Date: 2026-02-14 23:19:41
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def champagneTower(self, poured: int, queryRow: int, queryGlass: int) -> float:
        cur = [float(poured)]
        for i in range(1, queryRow + 1):
            nxt = [0.0] * (i + 1)
            for j, x in enumerate(cur):
                if x > 1:
                    nxt[j] += (x - 1) / 2
                    nxt[j + 1] += (x - 1) / 2
            cur = nxt
        return min(cur[queryGlass], 1.0)
# leetcode submit region end(Prohibit modification and deletion)
