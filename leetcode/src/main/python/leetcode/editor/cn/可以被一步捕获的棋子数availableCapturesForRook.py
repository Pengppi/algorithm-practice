"""
Title: 999.可以被一步捕获的棋子数
Title Slug: availableCapturesForRook
Author: Neo
Date: 2024-12-06 13:07:31
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        n = len(board)
        x = y = -1
        for i, row in enumerate(board):
            for j, cell in enumerate(row):
                if cell == "R":
                    x = i
                    y = j
                    break
        ans = 0
        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            nx, ny = x + dx, y + dy
            while 0 <= nx < n and 0 <= ny < n:
                if board[nx][ny] == "p":
                    ans += 1
                    break
                if board[nx][ny] == "B":
                    break
                nx += dx
                ny += dy
        return ans
# leetcode submit region end(Prohibit modification and deletion)
