"""
Title: 699.掉落的方块
Title Slug: fallingSquares
Author: Neo
Date: 2024-07-28 01:36:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def fallingSquares(self, positions: List[List[int]]) -> List[int]:
        n = len(positions)
        ans = []
        for i, (l1, w) in enumerate(positions):
            r1 = l1 + w - 1
            h = w
            for j in range(i):
                l2 = positions[j][0]
                r2 = l2 + positions[j][1] - 1
                if r1 >= l2 and r2 >= l1:
                    h = max(h, ans[j] + w)
            ans.append(h)
        for i in range(1, n):
            ans[i] = max(ans[i], ans[i - 1])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
