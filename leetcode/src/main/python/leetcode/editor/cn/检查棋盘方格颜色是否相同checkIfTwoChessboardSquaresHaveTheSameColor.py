"""
Title: 3274.检查棋盘方格颜色是否相同
Title Slug: checkIfTwoChessboardSquaresHaveTheSameColor
Author: Neo
Date: 2024-12-03 12:20:39
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkTwoChessboards(self, coordinate1: str, coordinate2: str) -> bool:
        def isBlack(s: str) -> bool:
            x, y = ord(s[0]) - ord('a') + 1, ord(s[1])
            return (x & 1) == (y & 1)

        return isBlack(coordinate1) == isBlack(coordinate2)
# leetcode submit region end(Prohibit modification and deletion)
