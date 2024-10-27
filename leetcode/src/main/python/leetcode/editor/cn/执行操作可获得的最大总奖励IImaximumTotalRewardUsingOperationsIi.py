"""
Title: 3181.执行操作可获得的最大总奖励 II
Title Slug: maximumTotalRewardUsingOperationsIi
Author: Neo
Date: 2024-10-26 18:22:30
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        f = 1
        for x in sorted(set(rewardValues)):
            f |= (f & (1 << x) - 1) << x
        return f.bit_length() - 1

# leetcode submit region end(Prohibit modification and deletion)
