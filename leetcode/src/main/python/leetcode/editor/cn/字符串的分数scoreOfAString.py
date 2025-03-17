"""
Title: 3110.字符串的分数
Title Slug: scoreOfAString
Author: Neo
Date: 2025-03-15 13:47:05
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def scoreOfString(self, s: str) -> int:
        return sum(abs(ord(s[i]) - ord(s[i - 1])) for i in range(1, len(s)))

# leetcode submit region end(Prohibit modification and deletion)
