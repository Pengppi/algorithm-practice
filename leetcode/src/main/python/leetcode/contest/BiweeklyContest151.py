from functools import cache
from math import inf
from typing import List


class Solution:
    def transformArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        for i in range(n):
            nums[i] = nums[i] & 1

        return sorted(nums)

    def countArrays(self, original: List[int], bounds: List[List[int]]) -> int:
        n = len(original)
        x = bounds[0][0]
        diff = bounds[0][1] - x
        i = 1
        while i < n:
            x = original[i] - original[i - 1] + x
            if x > bounds[i][1]:
                return 0
            if x < bounds[i][0]:
                d = bounds[i][0] - x
                if d > diff:
                    return 0
                x = bounds[i][0]
                diff -= d
            diff = min(diff, bounds[i][1] - x)
            i += 1
        if i == n:
            return 1 + diff
        return 0

    def minCost(self, nums: List[int]) -> int:
        def find_closest_pair(a, b, c):
            diff_ab = abs(a - b)
            diff_ac = abs(a - c)
            diff_bc = abs(b - c)

            min_diff = min(diff_ab, diff_ac, diff_bc)

            if min_diff == diff_ab:
                return c, max(a, b)
            elif min_diff == diff_ac:
                return b, max(a, c)
            else:
                return a, max(b, c)

        def dfs(cards: List[int]):
            if len(cards) == 3:
                return max(cards) + min(cards)
            if len(cards) < 3:
                return max(cards)
            x = cards.pop(0)
            y = cards.pop(0)
            z = cards.pop(0)
            c, cost = find_closest_pair(x, y, z)
            return dfs([c] + cards) + cost

        return dfs(nums)
