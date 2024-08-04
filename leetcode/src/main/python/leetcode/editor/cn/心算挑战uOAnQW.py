"""
Title: LCP 40.心算挑战
Title Slug: uOAnQW
Author: Neo
Date: 2024-08-01 22:45:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxmiumScore(self, cards: List[int], cnt: int) -> int:
        cards.sort(reverse=True)
        s = sum(cards[:cnt])
        if s & 1 == 0:
            return s

        def replace_sum(x: int) -> int:
            for card in cards[cnt:]:
                if card & 1 != x & 1:
                    return s + card - x
            return 0

        x = cards[cnt - 1]
        ans = replace_sum(x)
        for card in cards[cnt - 1::-1]:
            if card & 1 != x & 1:
                ans = max(ans, replace_sum(card))
                break
        return ans
    # leetcode submit region end(Prohibit modification and deletion)
