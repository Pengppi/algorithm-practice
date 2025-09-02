"""
Title: 679.24 Game
Title Slug: two4Game
Author: Neo
Date: 2025-08-18 18:39:24
"""
from typing import List

# leetcode submit region begin(Prohibit modification and deletion)
from fractions import Fraction


class Solution:
    def judgePoint24(self, cards: List[int]) -> bool:
        def dfs(remain_cards: List[Fraction]) -> bool:
            n = len(remain_cards)
            if n == 1:
                return remain_cards[0] == 24

            for i, x in enumerate(remain_cards[:-1]):
                for j in range(i + 1, n):
                    y = remain_cards[j]
                    res_list = [x - y, y - x, x + y, x * y]
                    if y:
                        res_list.append(Fraction(x, y))
                    if x:
                        res_list.append(Fraction(y, x))

                    next_cards = remain_cards[:j] + remain_cards[j + 1:]
                    for r in res_list:
                        next_cards[i] = r
                        if dfs(next_cards):
                            return True
            return False

        return dfs(list(map(Fraction, cards)))
        # leetcode submit region end(Prohibit modification and deletion)
