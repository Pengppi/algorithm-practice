"""
Title: 3461.Check If Digits Are Equal in String After Operations I
Title Slug: checkIfDigitsAreEqualInStringAfterOperationsI
Author: Neo
Date: 2025-10-23 11:58:54
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def hasSameDigits(self, s: str) -> bool:
        s = list(map(int, s))
        while len(s) > 2:
            t = []
            for i in range(len(s) - 1):
                t.append((s[i] + s[i + 1]) % 10)
            s = t
        return s[0] == s[1]
# leetcode submit region end(Prohibit modification and deletion)
