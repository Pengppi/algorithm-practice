"""
Title: 2273.Find Resultant Array After Removing Anagrams
Title Slug: findResultantArrayAfterRemovingAnagrams
Author: Neo
Date: 2025-10-13 12:36:38
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        n = len(words)

        def is_anagram(i: int, j: int):
            s, t = list(words[i]), list(words[j])
            s.sort()
            t.sort()
            return s == t

        for i in range(n - 2, -1, -1):
            if is_anagram(i, i + 1):
                del words[i + 1]
        return words

# leetcode submit region end(Prohibit modification and deletion)
