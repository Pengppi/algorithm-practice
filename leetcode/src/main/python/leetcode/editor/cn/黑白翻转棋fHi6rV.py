"""
Title: LCP 41.黑白翻转棋
Title Slug: fHi6rV
Author: Neo
Date: 2025-04-19 18:07:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def flipChess(self, chessboard: List[str]) -> int:
        def bfs(i: int, j: int) -> int:
            q = [(i, j)]
            g = [list(row) for row in chessboard]
            g[i][j] = 'X'
            cnt = 0
            while q:
                i, j = q.pop(0)
                for dx, dy in dirs:
                    x, y = i + dx, j + dy
                    while 0 <= x < m and 0 <= y < n and g[x][y] == 'O':
                        x, y = x + dx, y + dy
                    if 0 <= x < m and 0 <= y < n and g[x][y] == "X":
                        x, y = x - dx, y - dy
                        cnt += max(abs(x - i), abs(y - j))
                        while x != i or y != j:
                            g[x][y] = "X"
                            q.append((x, y))
                            x, y = x - dx, y - dy

            return cnt

        m, n = len(chessboard), len(chessboard[0])
        dirs = [(a, b) for a in range(-1, 2) for b in range(-1, 2) if a or b]
        return max(bfs(i, j) for i in range(m) for j in range(n) if chessboard[i][j] == ".")

# leetcode submit region end(Prohibit modification and deletion)
