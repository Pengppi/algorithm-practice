"""
Title: 3306.元音辅音字符串计数 II
Title Slug: countOfSubstringsContainingEveryVowelAndKConsonantsIi
Author: Neo
Date: 2025-03-13 12:34:36
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countOfSubstrings(self, word: str, k: int) -> int:
        def atLeast(word: str, k: int):
            cnt1 = defaultdict(int)
            cnt2 = 0
            l = ans = 0
            vowels = "aeiou"
            for c in word:
                if c in vowels:
                    cnt1[c] += 1
                else:
                    cnt2 += 1
                while len(cnt1) == len(vowels) and cnt2 >= k:
                    le = word[l]
                    l += 1
                    if le in vowels:
                        cnt1[le] -= 1
                        if cnt1[le] == 0:
                            del cnt1[le]
                    else:
                        cnt2 -= 1
                ans += l
            return ans

        return atLeast(word, k) - atLeast(word, k + 1)
# leetcode submit region end(Prohibit modification and deletion)
