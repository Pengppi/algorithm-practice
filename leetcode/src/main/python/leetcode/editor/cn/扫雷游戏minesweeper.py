"""
Title: 529.扫雷游戏
Title Slug: minesweeper
Author: Neo
Date: 2024-05-03 20:55:49
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        m, n = len(board), len(board[0])

        def search(x: int, y: int) -> int:
            cnt = 0
            for i in range(x - 1, x + 2):
                for j in range(y - 1, y + 2):
                    if 0 <= i < m and 0 <= j < n:
                        cnt += 1 if board[i][j] == 'M' else 0
            return cnt

        def dfs(x: int, y: int):
            if board[x][y] == 'M':
                board[x][y] = 'X'
                return
            else:
                cnt = search(x, y)
                if cnt == 0:
                    board[x][y] = 'B'
                    for i in range(x - 1, x + 2):
                        for j in range(y - 1, y + 2):
                            if 0 <= i < m and 0 <= j < n and board[i][j] == 'E':
                                dfs(i, j)
                else:
                    board[x][y] = str(cnt)
                return 0

        dfs(click[0], click[1])
        return board

# leetcode submit region end(Prohibit modification and deletion)
