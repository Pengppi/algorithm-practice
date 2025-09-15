"""
Title: 3227.Vowels Game in a String
Title Slug: vowelsGameInAString
Author: Neo
Date: 2025-09-12 12:53:30
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def doesAliceWin(self, s: str) -> bool:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        vowel_cnt = sum(1 for c in s if c in vowels)
        if vowel_cnt == 0:
            return False
        return True



# leetcode submit region end(Prohibit modification and deletion)
