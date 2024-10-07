"""
Title: 1227.飞机座位分配概率
Title Slug: airplaneSeatAssignmentProbability
Author: Neo
Date: 2024-10-04 21:28:11
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nthPersonGetsNthSeat(self, n: int) -> float:
        if n == 1:
            return 1.0
        else:
            return 0.5

# leetcode submit region end(Prohibit modification and deletion)
