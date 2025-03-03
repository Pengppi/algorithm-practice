"""
Title: 132.分割回文串 II
Title Slug: palindromePartitioningIi
Author: Neo
Date: 2025-03-02 15:05:50
"""
from functools import cache
from math import inf


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minCut(self, s: str) -> int:

        @cache
        def isValid(l, r):
            if l >= r:
                return True
            return s[l] == s[r] and isValid(l + 1, r - 1)

        @cache
        def dfs(x):
            if isValid(0, x):
                return 0
            res = inf
            for l in range(1, x + 1):
                if isValid(l, x):
                    res = min(res, dfs(l - 1) + 1)
            return res

        return dfs(len(s) - 1)
# leetcode submit region end(Prohibit modification and deletion)
