"""
Title: 688.骑士在棋盘上的概率
Title Slug: knightProbabilityInChessboard
Author: Neo
Date: 2024-12-07 23:40:25
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        dir = [0, 2, 0, -2, 0]

        @cache
        def dfs(cnt, x, y):
            if x < 0 or x >= n or y < 0 or y >= n:
                return 0
            if cnt == 0:
                return 1
            res = 0
            for l in range(4):
                if dir[l] == 0:
                    for dx in [-1, 1]:
                        nx, ny = x + dx, y + dir[l + 1]
                        res += dfs(cnt - 1, nx, ny) / 8
                else:
                    for dy in [-1, 1]:
                        nx, ny = x + dir[l], y + dy
                        res += dfs(cnt - 1, nx, ny) / 8
            return res

        return dfs(k, row, column)

# leetcode submit region end(Prohibit modification and deletion)
