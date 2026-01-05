"""
Title: 1250.Check If It Is a Good Array
Title Slug: checkIfItIsAGoodArray
Author: Neo
Date: 2026-01-01 15:50:55
"""

# leetcode submit region begin(Prohibit modification and deletion)
from math import gcd
from typing import List


class Solution:

    def isGoodArray(self, nums: List[int]) -> bool:

        g = nums[0]
        for x in nums[1:]:
            g = gcd(g, x)
            if g == 1:
                return True

        return g == 1


# leetcode submit region end(Prohibit modification and deletion)
