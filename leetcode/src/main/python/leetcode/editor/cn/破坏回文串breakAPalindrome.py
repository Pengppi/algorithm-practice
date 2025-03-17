"""
Title: 1328.破坏回文串
Title Slug: breakAPalindrome
Author: Neo
Date: 2025-03-05 12:32:06
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        n = len(palindrome)
        if n == 1:
            return ""
        for i in range(n // 2):
            if palindrome[i] != 'a':
                return palindrome[:i] + 'a' + palindrome[i + 1:]
        return palindrome[:-1] + 'b'

# leetcode submit region end(Prohibit modification and deletion)
