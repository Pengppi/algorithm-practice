"""
Title: 909.蛇梯棋
Title Slug: snakesAndLadders
Author: Neo
Date: 2025-06-06 19:25:31
"""
from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)

        def get_pos(num: int) -> (int, int):
            num -= 1
            i = n - 1 - num // n
            j = num % n
            if i & 1 == n & 1:
                j = n - 1 - j
            return i, j

        seen = [False] * (n * n + 1)
        seen[1] = True
        q = deque()
        q.append(1)
        ans = 0
        while q:
            for _ in range(len(q)):
                x = q.popleft()
                for y in range(x + 1, min(x + 6, n * n) + 1):
                    if seen[y]:
                        continue
                    seen[y] = True
                    dest = y
                    i, j = get_pos(y)
                    if board[i][j] != -1:
                        dest = board[i][j]
                    if dest == n * n:
                        return ans + 1
                    q.append(dest)
            ans += 1
        return -1
# leetcode submit region end(Prohibit modification and deletion)
