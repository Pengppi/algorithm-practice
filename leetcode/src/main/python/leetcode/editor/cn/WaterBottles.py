"""
Title: 1518.Water Bottles
Title Slug: waterBottles
Author: Neo
Date: 2025-10-01 11:05:45
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        drink = 0
        empty = 0
        while numBottles:
            drink += numBottles
            empty += numBottles
            numBottles = 0
            if empty >= numExchange:
                numBottles = empty // numExchange
                empty %= numExchange
        return drink

# leetcode submit region end(Prohibit modification and deletion)
