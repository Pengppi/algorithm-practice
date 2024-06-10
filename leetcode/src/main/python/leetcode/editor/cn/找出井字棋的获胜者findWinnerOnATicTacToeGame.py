"""
Title: 1275.找出井字棋的获胜者
Title Slug: findWinnerOnATicTacToeGame
Author: Neo
Date: 2024-06-10 13:11:09
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        n = 3
        mat = [[0 for _ in range(n)] for _ in range(n)]
        f = 1
        for x, y in moves:
            mat[x][y] = f
            f = -f
        if abs(mat[0][0] + mat[1][1] + mat[2][2]) == 3 or abs(mat[0][2] + mat[1][1] + mat[2][0]) == 3:
            return "A" if mat[1][1] > 0 else "B"
        for k in range(3):
            if abs(sum(mat[k][j] for j in range(3))) == 3 or abs(sum(mat[i][k] for i in range(3))) == 3:
                return "A" if mat[k][k] > 0 else "B"
        return "Draw" if len(moves) == 9 else "Pending"

# leetcode submit region end(Prohibit modification and deletion)
