"""
Title: 36.Valid Sudoku
Title Slug: validSudoku
Author: Neo
Date: 2025-08-30 15:47:54
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = 9
        rows = [0] * n
        cols = [0] * n
        grids = [0] * n
        for i, row in enumerate(board):
            for j, x in enumerate(row):
                if x == '.':
                    continue
                grid_id = i // 3 * 3 + j // 3
                cur = (1 << int(x))
                if rows[i] & cur or cols[j] & cur or grids[grid_id] & cur:
                    return False
                rows[i] |= cur
                cols[j] |= cur
                grids[grid_id] |= cur

        return True
    # leetcode submit region end(Prohibit modification and deletion)


Solution().isValidSudoku(
    [["5", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."], [".", "9", "8", ".", ".", ".", ".", "6", "."],
     ["8", ".", ".", ".", "6", ".", ".", ".", "3"], ["4", ".", ".", "8", ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
     [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"], [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
