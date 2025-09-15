"""
Title: 2785.Sort Vowels in a String
Title Slug: sortVowelsInAString
Author: Neo
Date: 2025-09-11 12:27:48
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sortVowels(self, s: str) -> str:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        sorted_vowels = list()
        for c in s:
            if c.lower() in vowels:
                sorted_vowels.append(c)
        sorted_vowels.sort()
        t_list = [''] * len(s)
        j = 0
        for i, c in enumerate(s):
            if c.lower() in vowels:
                t_list[i] = sorted_vowels[j]
                j += 1
            else:
                t_list[i] = c
        return ''.join(t_list)


# leetcode submit region end(Prohibit modification and deletion)
Solution().sortVowels("lEetcOde")
