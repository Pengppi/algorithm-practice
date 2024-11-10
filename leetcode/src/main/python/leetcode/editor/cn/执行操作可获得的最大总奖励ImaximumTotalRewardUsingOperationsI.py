"""
Title: 3180.执行操作可获得的最大总奖励 I
Title Slug: maximumTotalRewardUsingOperationsI
Author: Neo
Date: 2024-10-25 12:11:19
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        rewardValues = sorted(set(rewardValues))
        f = 1
        for x in rewardValues:
            f |= (f & ((1 << x) - 1)) << x
        return f.bit_length() - 1
# leetcode submit region end(Prohibit modification and deletion)
