"""
Title: 1625.Lexicographically Smallest String After Applying Operations
Title Slug: lexicographicallySmallestStringAfterApplyingOperations
Author: Neo
Date: 2025-10-19 13:45:00
"""
from typing import List

from sortedcontainers import SortedSet


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        def accumulate(t: str) -> str:
            res = ""
            for i, c in enumerate(t):
                if i & 1 == 0:
                    res += c
                else:
                    res += str((int(c) + a) % 10)
            return res

        def rotate(t: str) -> str:
            return t[-b:] + t[:-b]

        st = SortedSet()

        def dfs(t: str):
            if t not in st:
                st.add(t)
                dfs(rotate(t))
                dfs(accumulate(t))

        dfs(s)

        return st[0]



# leetcode submit region end(Prohibit modification and deletion)

