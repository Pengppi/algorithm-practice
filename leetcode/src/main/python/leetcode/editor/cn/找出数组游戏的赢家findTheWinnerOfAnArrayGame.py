"""
Title: 1535.找出数组游戏的赢家
Title Slug: findTheWinnerOfAnArrayGame
Author: Neo
Date: 2024-05-19 00:03:08
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        mx = arr[0]
        streak = -1
        for x in arr:
            if x > mx:
                mx = x
                streak = 0
            streak += 1
            if streak == k:
                return mx
        return mx
# leetcode submit region end(Prohibit modification and deletion)
