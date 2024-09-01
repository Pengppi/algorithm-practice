"""
Title: 822.翻转卡片游戏
Title Slug: cardFlippingGame
Author: Neo
Date: 2024-08-29 23:39:08
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def flipgame(self, fronts: List[int], backs: List[int]) -> int:
        st = set()
        for i in range(len(fronts)):
            if fronts[i] == backs[i]:
                st.add(fronts[i])

        for x in sorted(fronts + backs):
            if x not in st:
                return x
        return 0

# leetcode submit region end(Prohibit modification and deletion)
