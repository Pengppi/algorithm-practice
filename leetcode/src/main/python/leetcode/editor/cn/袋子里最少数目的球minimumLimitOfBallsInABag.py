"""
Title: 1760.袋子里最少数目的球
Title Slug: minimumLimitOfBallsInABag
Author: Neo
Date: 2025-02-12 12:32:47
"""
import bisect
import math
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:

        def check(x):
            cnt = 0
            for num in nums:
                if num <= x:
                    continue
                cnt += (num + x - 1) // x - 1
                if cnt > maxOperations:
                    return False
            return True

        mx = max(nums)
        return bisect.bisect_left(range(mx + 1), x=True, lo=1, key=check)


# leetcode submit region end(Prohibit modification and deletion)

