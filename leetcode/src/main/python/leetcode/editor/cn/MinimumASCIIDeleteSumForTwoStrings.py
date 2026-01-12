"""
Title: 712.Minimum ASCII Delete Sum for Two Strings
Title Slug: minimumAsciiDeleteSumForTwoStrings
Author: Neo
Date: 2026-01-10 17:31:46
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        n1, n2 = len(s1), len(s2)
        f = [[0] * (n2 + 1) for _ in range(n1 + 1)]
        for i in range(1, n1 + 1):
            for j in range(1, n2 + 1):
                if s1[i - 1] == s2[j - 1]:
                    f[i][j] = f[i - 1][j - 1] + ord(s1[i - 1])
                else:
                    f[i][j] = max(f[i - 1][j], f[i][j - 1])

        s = sum(ord(c) for c in s1 + s2)
        return s - 2 * f[n1][n2]


# leetcode submit region end(Prohibit modification and deletion)
