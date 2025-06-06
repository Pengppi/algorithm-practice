"""
Title: 1061.按字典序排列最小的等效字符串
Title Slug: lexicographicallySmallestEquivalentString
Author: Neo
Date: 2025-06-05 18:34:02
"""
from functools import cache
from string import ascii_lowercase


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        fa = {c: c for c in ascii_lowercase}

        def find(x):
            if fa[x] != x:
                fa[x] = find(fa[x])
            return fa[x]

        def merge(a: str, b: str):
            mn, mx = sorted((find(a), find(b)))
            fa[mx] = mn

        for x, y in zip(s1, s2):
            merge(x, y)

        return "".join(find(c) for c in baseStr)

# leetcode submit region end(Prohibit modification and deletion)
