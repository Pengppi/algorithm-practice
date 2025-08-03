"""
Title: 3136.Valid Word
Title Slug: validWord
Author: Neo
Date: 2025-07-15 18:33:48
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValid(self, word: str) -> bool:
        if len(word) < 3:
            return False
        vowels = set("aeiou")
        has_vowel = False
        has_consonant = False
        for c in word:
            if c.isdigit():
                continue
            elif not c.isalpha():
                return False
            if c.lower() in vowels:
                has_vowel = True
            else:
                has_consonant = True

        return has_vowel and has_consonant
# leetcode submit region end(Prohibit modification and deletion)
