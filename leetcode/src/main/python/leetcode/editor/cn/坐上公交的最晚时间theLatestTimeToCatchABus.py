"""
Title: 2332.坐上公交的最晚时间
Title Slug: theLatestTimeToCatchABus
Author: Neo
Date: 2024-09-18 12:37:13
"""
from tkinter.messagebox import RETRY
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def latestTimeCatchTheBus(self, buses: List[int], passengers: List[int], capacity: int) -> int:
        n, m = len(buses), len(passengers),
        i, j = 0, 0
        buses.sort()
        passengers.sort()
        st = set(passengers)
        k = capacity
        while i < n - 1 and j < m:
            if buses[i] >= passengers[j]:
                j += 1
                k -= 1
                if k == 0:
                    i += 1
                    k = capacity
            else:
                i += 1
                k = capacity
        j += capacity - 1
        if j >= m:
            ans = buses[n - 1]
        else:
            ans = min(passengers[j] - 1, buses[n - 1])
        while ans in st:
            ans -= 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
