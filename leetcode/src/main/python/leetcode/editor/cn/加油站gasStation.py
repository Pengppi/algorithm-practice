"""
Title: 134.加油站
Title Slug: gasStation
Author: Neo
Date: 2024-10-06 20:40:44
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        i = 0
        while i < n:
            j = i
            total = 0
            while True:
                total += gas[j] - cost[j]
                if total < 0:
                    if j < i:
                        return -1
                    break
                j = (j + 1) % n
                if j == i:
                    return i
            i = j + 1
        return -1


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().canCompleteCircuit(gas=[2, 3, 4], cost=[3, 4, 3]))
