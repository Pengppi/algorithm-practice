"""
Title: 419.甲板上的战舰
Title Slug: battleshipsInABoard
Author: Neo
Date: 2024-06-11 12:08:29
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        m, n = len(board), len(board[0])

        def dfs(x: int, y: int):
            if x < 0 or x >= m or y < 0 or y >= n or board[x][y] == '.':
                return
            board[x][y] = '.'
            dfs(x + 1, y)
            dfs(x, y + 1)

        ans = 0
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'X':
                    dfs(i, j)
                    ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
