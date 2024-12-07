"""
Title: 3232.判断是否可以赢得数字游戏
Title Slug: findIfDigitGameCanBeWon
Author: Neo
Date: 2024-11-30 23:36:29
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canAliceWin(self, nums: List[int]) -> bool:
        s = s1 = s2 = 0
        for x in nums:
            s += x
            if x < 10:
                s1 += x
            else:
                s2 += x
        return s1 * 2 > s or s2 * 2 > s

    # leetcode submit region end(Prohibit modification and deletion)
