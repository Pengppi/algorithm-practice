"""
Title: 2573.Find the String with LCP
Title Slug: findTheStringWithLcp
Author: Neo
Date: 2026-03-28 10:35:14
"""

from string import ascii_lowercase
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findTheString(self, lcp: List[List[int]]) -> str:
        n = len(lcp)
        s = [''] * n
        i = 0
        for c in ascii_lowercase:
            for j in range(i, n):
                if lcp[i][j]:
                    s[j] = c
            while i < n and s[i]:
                i += 1
            if i == n:
                break

        if i < n:
            return ""

        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if s[i] != s[j]:
                    actual = 0
                else:
                    actual = 1 if i == n - 1 or j == n - 1 else 1 + lcp[i + 1][j + 1]
                if lcp[i][j] != actual:
                    return ""

        return "".join(s)


# leetcode submit region end(Prohibit modification and deletion)
