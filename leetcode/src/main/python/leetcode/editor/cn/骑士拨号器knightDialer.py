"""
Title: 935.骑士拨号器
Title Slug: knightDialer
Author: Neo
Date: 2024-12-10 16:23:36
"""
from functools import cache

# leetcode submit region begin(Prohibit modification and deletion)

mod = 10 ** 9 + 7

dirs = [(-1, -2), (-2, -1), (-2, 1), (-1, 2), (1, -2), (2, -1), (2, 1), (1, 2)]
m = 4
n = 3


@cache
def dfs(x, y, cnt):
    if cnt == 0:
        return 1
    res = 0
    for dx, dy in dirs:
        nx, ny = x + dx, y + dy
        if nx >= m or nx < 0 or ny >= n or ny < 0:
            continue
        if (nx, ny) in [(3, 0), (3, 2)]:
            continue
        res = (dfs(nx, ny, cnt - 1) + res) % mod
    return res


class Solution:
    def knightDialer(self, N: int) -> int:
        ans = 0
        for i in range(m):
            for j in range(n):
                if (i, j) in [(3, 0), (3, 2)]:
                    continue
                ans = (ans + dfs(i, j, N - 1)) % mod
        return ans
        # leetcode submit region end(Prohibit modification and deletion)
