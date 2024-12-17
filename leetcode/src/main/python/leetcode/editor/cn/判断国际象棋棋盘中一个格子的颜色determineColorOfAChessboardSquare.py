"""
Title: 1812.判断国际象棋棋盘中一个格子的颜色
Title Slug: determineColorOfAChessboardSquare
Author: Neo
Date: 2024-12-09 12:22:56
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def squareIsWhite(self, coordinates: str) -> bool:
        return (ord(coordinates[0]) - ord("a") + int(coordinates[1])) & 1 == 0

# leetcode submit region end(Prohibit modification and deletion)
