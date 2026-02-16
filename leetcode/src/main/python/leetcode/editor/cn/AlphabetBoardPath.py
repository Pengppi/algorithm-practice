"""
Title: 1138.Alphabet Board Path
Title Slug: alphabetBoardPath
Author: Neo
Date: 2026-02-15 17:02:39
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def alphabetBoardPath(self, target: str) -> str:
        x, y = 0, 0
        board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]
        mp = dict()
        for i, row in enumerate(board):
            for j, c in enumerate(row):
                mp[c] = (i, j)
        ans = []

        for t in target:
            tx, ty = mp[t]
            v = "UD"[x < tx] * abs(x - tx)
            h = "LR"[y < ty] * abs(y - ty)
            x, y = tx, ty
            ans.append((h + v if t == "z" else v + h) + "!")

        return "".join(ans)


# leetcode submit region end(Prohibit modification and deletion)
