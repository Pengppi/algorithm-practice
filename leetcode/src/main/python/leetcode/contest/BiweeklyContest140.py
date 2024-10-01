from audioop import reverse
from bisect import bisect_left
from cmath import inf
from collections import Counter, defaultdict
from functools import cache
from typing import List


class Solution:
    def minElement(self, nums: List[int]) -> int:
        ans = inf
        for num in nums:
            t = num
            s = 0
            while t > 0:
                s += t % 10
                t //= 10
            ans = min(ans, s)
        return ans

    def maximumTotalSum(self, maximumHeight: List[int]) -> int:
        maximumHeight.sort(reverse=True)
        for i, x in enumerate(maximumHeight):
            if i > 0 and x >= maximumHeight[i - 1]:
                maximumHeight[i] = maximumHeight[i - 1] - 1
                if maximumHeight[i] <= 0:
                    return -1
        return sum(maximumHeight)

