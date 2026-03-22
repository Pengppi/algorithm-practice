"""
Title: 2335.Minimum Amount of Time to Fill Cups
Title Slug: minimumAmountOfTimeToFillCups
Author: Neo
Date: 2026-03-20 19:38:02
"""

# leetcode submit region begin(Prohibit modification and deletion)
from math import ceil
from typing import List


class Solution:
    def fillCups(self, amount: List[int]) -> int:
        amount.sort()
        if amount[2] >= amount[0] + amount[1]:
            return amount[2]
        else:
            return amount[2] + ceil((amount[1] + amount[0] - amount[2]) / 2)


# leetcode submit region end(Prohibit modification and deletion)
# https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/solutions/2099731/zhang-yu-lai-shua-ti-c17-san-chong-jie-f-duzp/
