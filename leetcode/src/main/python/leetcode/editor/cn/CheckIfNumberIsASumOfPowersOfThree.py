"""
Title: 1780.Check if Number is a Sum of Powers of Three
Title Slug: checkIfNumberIsASumOfPowersOfThree
Author: Neo
Date: 2025-08-14 18:19:34
"""
import bisect
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkPowersOfThree(self, n: int) -> bool:
        pows = [1] * 15
        for i in range(1, 15):
            pows[i] = pows[i - 1] * 3

        @cache
        def dfs(x: int, mask: int):
            for i, p in enumerate(pows):
                if mask & (1 << i):
                    continue
                if p > n:
                    break
                if p == x or dfs(x - p, mask | (1 << i)):
                    return True
            return False

        return dfs(n, 0)
