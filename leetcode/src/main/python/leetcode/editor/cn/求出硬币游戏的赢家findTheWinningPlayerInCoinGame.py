"""
Title: 3222.求出硬币游戏的赢家
Title Slug: findTheWinningPlayerInCoinGame
Author: Neo
Date: 2024-11-05 12:29:22
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def losingPlayer(self, x: int, y: int) -> str:
        cnt = 1 + min(x, y // 4)
        return 'Bob' if cnt & 1 else 'Alice'
    # leetcode submit region end(Prohibit modification and deletion)
