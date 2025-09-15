"""
Title: 3541.Find Most Frequent Vowel and Consonant
Title Slug: findMostFrequentVowelAndConsonant
Author: Neo
Date: 2025-09-13 09:58:53
"""
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxFreqSum(self, s: str) -> int:
        vowel_cnt = Counter([c for c in s if c in "aeiou"])
        consonant_cnt = Counter([c for c in s if c not in "aeiou"])
        ans = max(vowel_cnt.values()) if vowel_cnt else 0
        ans += max(consonant_cnt.values()) if consonant_cnt else 0
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().maxFreqSum("aeiou")
