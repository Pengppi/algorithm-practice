"""
Title: 1140.Stone Game II
Title Slug: stoneGameIi
Author: Neo
Date: 2025-12-22 19:45:21
"""
from functools import cache
# leetcode submit region begin(Prohibit modification and deletion)
from itertools import accumulate


class Solution:

    def stoneGameII(self, piles: List[int]) -> int:
        n = len(piles)
        ps = list(accumulate(piles, initial=0))
        @cache
        def dfs(i: int, M: int) -> int:
            res = 0
            for x in range(1, 2 * M + 1):
                j = i + x
                if j > n:
                    break
                res = max(res,
                          ps[j] - ps[i] + (ps[n] - ps[j] - dfs(j, max(M, x))))
            return res

        return dfs(0, 1)


# leetcode submit region end(Prohibit modification and deletion)
