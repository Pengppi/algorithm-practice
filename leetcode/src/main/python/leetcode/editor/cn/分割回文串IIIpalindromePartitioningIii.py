"""
Title: 1278.分割回文串 III
Title Slug: palindromePartitioningIii
Author: Neo
Date: 2025-03-03 12:54:54
"""
from cmath import inf
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def palindromePartition(self, s: str, k: int) -> int:
        @cache
        def change(l, r):
            if l >= r:
                return 0
            return change(l + 1, r - 1) + (0 if s[l] == s[r] else 1)

        @cache
        def dfs(x, c):
            if c == 1:
                return change(0, x)
            res = inf
            for i in range(c - 1, x + 1):
                res = min(res, change(i, x) + dfs(i - 1, c - 1))
            return res

        return dfs(len(s) - 1, k)
# leetcode submit region end(Prohibit modification and deletion)
