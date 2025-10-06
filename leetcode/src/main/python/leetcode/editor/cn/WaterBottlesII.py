"""
Title: 3100.Water Bottles II
Title Slug: waterBottlesIi
Author: Neo
Date: 2025-10-02 12:35:23
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        ans = 0
        empty = 0
        while numBottles:
            ans += numBottles
            empty += numBottles
            numBottles = 0
            while empty >= numExchange:
                empty -= numExchange
                numBottles += 1
                numExchange += 1

        return ans
# leetcode submit region end(Prohibit modification and deletion)
