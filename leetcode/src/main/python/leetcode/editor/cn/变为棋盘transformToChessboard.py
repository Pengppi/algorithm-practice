"""
Title: 782.变为棋盘
Title Slug: transformToChessboard
Author: Neo
Date: 2024-12-08 13:40:11
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def movesToChessboard(self, board: List[List[int]]) -> int:
        row_cnt = Counter(board[0])
        if abs(row_cnt[0] - row_cnt[1]) > 1:
            return -1
        first_col = list(next(zip(*board)))
        col_cnt = Counter(first_col)
        if abs(col_cnt[0] - col_cnt[1]) > 1:
            return -1
        for row in board[1:]:
            same = row[0] == board[0][0]
            for x, y in zip(row, board[0]):
                if same != (x == y):
                    return -1

        def min_swap(arr, cnt):
            n = len(arr)
            x0 = 1 if cnt[1] > cnt[0] else 0
            diff = sum(i % 2 ^ x ^ x0 for i, x in enumerate(arr))
            return diff // 2 if n & 1 else min(diff, n - diff) // 2

        return min_swap(board[0], row_cnt) + min_swap(first_col, col_cnt)
# leetcode submit region end(Prohibit modification and deletion)
