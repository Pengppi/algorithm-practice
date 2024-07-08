"""
Title: 1958.检查操作是否合法
Title Slug: checkIfMoveIsLegal
Author: Neo
Date: 2024-07-07 10:28:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkMove(self, board: List[List[str]], rMove: int, cMove: int, color: str) -> bool:
        m, n = len(board), len(board[0])
        for dx, dy in (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1):
            x, y = rMove + dx, cMove + dy
            if x < 0 or y < 0 or x >= m or y >= m or board[x][y] == '.' or board[x][y] == color:
                continue
            while True:
                x += dx
                y += dy
                if x < 0 or y < 0 or x >= m or y >= m or board[x][y] == '.':
                    break
                if board[x][y]==color:
                    return True
        return False

# leetcode submit region end(Prohibit modification and deletion)
