"""
Title: 1411.Number of Ways to Paint N × 3 Grid
Title Slug: numberOfWaysToPaintN3Grid
Author: Neo
Date: 2026-01-03 15:48:58
"""

# leetcode submit region begin(Prohibit modification and deletion)

from functools import cache

mod = 10**9 + 7


@cache
def dfs(i: int, j: int, pre: int, cur: int) -> int:
    if i == 0:
        return 1
    if j == 3:
        return dfs(i - 1, 0, cur, 0)

    res = 0
    for color in range(3):
        if j and color == cur >> ((j - 1) * 2) & 3:
            continue
        if pre and color == pre >> (j * 2) & 3:
            continue
        res += dfs(i, j + 1, pre, cur | (color << (j * 2)))
        res %= mod
    return res


class Solution:

    def numOfWays(self, n: int) -> int:
        return dfs(n, 0, 0, 0)


# leetcode submit region end(Prohibit modification and deletion)
