"""
Title: 3021.Alice and Bob Playing Flower Game
Title Slug: aliceAndBobPlayingFlowerGame
Author: Neo
Date: 2025-08-29 21:09:34
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        even1 = n // 2
        odd1 = n - even1

        even2 = m // 2
        odd2 = m - even2
        return odd1 * even2 + odd2 * even1

    # leetcode submit region end(Prohibit modification and deletion)
