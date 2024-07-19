"""
Title: 3096.得到更多分数的最少关卡数目
Title Slug: minimumLevelsToGainMorePoints
Author: Neo
Date: 2024-07-19 13:09:51
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumLevels(self, possible: List[int]) -> int:
        tot_sum = 0
        n = len(possible)
        for i in range(n):
            if possible[i] == 0:
                tot_sum -= 1
            else:
                tot_sum += 1
        cur_sum = 0
        for i in range(n - 1):
            if possible[i] == 0:
                cur_sum -= 1
            else:
                cur_sum += 1
            if cur_sum * 2 > tot_sum:
                return i + 1
        return -1

# leetcode submit region end(Prohibit modification and deletion)
