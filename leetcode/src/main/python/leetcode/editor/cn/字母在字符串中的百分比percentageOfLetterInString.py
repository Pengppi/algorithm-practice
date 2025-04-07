"""
Title: 2278.字母在字符串中的百分比
Title Slug: percentageOfLetterInString
Author: Neo
Date: 2025-03-31 18:53:06
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def percentageLetter(self, s: str, letter: str) -> int:
            return int(s.count(letter) / len(s) * 100)
# leetcode submit region end(Prohibit modification and deletion)

