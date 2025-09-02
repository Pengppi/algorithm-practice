"""
Title: 37.Sudoku Solver
Title Slug: sudokuSolver
Author: Neo
Date: 2025-08-31 11:34:42
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        n = 9
        rows = [0] * n
        cols = [0] * n
        grids = [[0] * 3 for _ in range(3)]
        for i, row in enumerate(board):
            for j, x in enumerate(row):
                if x == '.':
                    continue
                cur = (1 << int(x))
                rows[i] |= cur
                cols[j] |= cur
                grids[i // 3][j // 3] |= cur

        def dfs(i, j):
            if j == n:
                j = 0
                i += 1
                if i == n:
                    return True
            if board[i][j] != '.':
                return dfs(i, j + 1)
            for num in range(1, 10):
                cur = (1 << num)
                if rows[i] & cur or cols[j] & cur or grids[i // 3][j // 3] & cur:
                    continue
                rows[i] |= cur
                cols[j] |= cur
                grids[i // 3][j // 3] |= cur
                board[i][j] = str(num)
                if dfs(i, j + 1):
                    return True
                rows[i] &= ~cur
                cols[j] &= ~cur
                grids[i // 3][j // 3] &= ~cur

            board[i][j] = '.'
            return False

        dfs(0, 0)


# leetcode submit region end(Prohibit modification and deletion)
Solution().solveSudoku(
    [["5", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."], [".", "9", "8", ".", ".", ".", ".", "6", "."],
     ["8", ".", ".", ".", "6", ".", ".", ".", "3"], ["4", ".", ".", "8", ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
     [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"], [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
