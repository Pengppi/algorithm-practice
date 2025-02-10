"""
Title: 680.验证回文串 II
Title Slug: validPalindromeIi
Author: Neo
Date: 2025-02-03 23:27:01
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def validPalindrome(self, s: str) -> bool:

        def check(i, j, first):
            if i >= j:
                return True
            if s[i] == s[j]:
                return check(i + 1, j - 1, first)
            if first:
                return check(i + 1, j, False) or check(i, j - 1, False)
            return False

        return check(0, len(s) - 1, True)
# leetcode submit region end(Prohibit modification and deletion)

Solution().validPalindrome("abc")