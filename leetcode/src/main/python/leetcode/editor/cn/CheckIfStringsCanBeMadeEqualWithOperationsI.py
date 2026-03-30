"""
Title: 2839.Check if Strings Can be Made Equal With Operations I
Title Slug: checkIfStringsCanBeMadeEqualWithOperationsI
Author: Neo
Date: 2026-03-29 11:23:34
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canBeEqual(self, s1: str, s2: str) -> bool:
        odd = set()
        even = set()
        for i, c in enumerate(s1):
            if i & 1:
                odd.add(c)
            else:
                even.add(c)

        for i, c in enumerate(s2):
            if i & 1:
                if c in odd:
                    odd.remove(c)
            else:
                if c in even:
                    even.remove(c)
        return len(odd) == 0 and len(even) == 0


# leetcode submit region end(Prohibit modification and deletion)
