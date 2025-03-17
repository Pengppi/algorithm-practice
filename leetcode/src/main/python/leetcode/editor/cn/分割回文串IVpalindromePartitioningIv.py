"""
Title: 1745.分割回文串 IV
Title Slug: palindromePartitioningIv
Author: Neo
Date: 2025-03-04 13:46:03
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkPartitioning(self, s: str) -> bool:

        @cache
        def isValid(l, r):
            if l >= r:
                return True
            return s[l] == s[r] and isValid(l + 1, r - 1)

        @cache
        def dfs(x, c):
            if c == 1:
                return isValid(0, x)
            for i in range(c - 1, x + 1):
                if isValid(i, x) and dfs(i - 1, c - 1):
                    return True
            return False

        return dfs(len(s) - 1, 3)

# leetcode submit region end(Prohibit modification and deletion)
