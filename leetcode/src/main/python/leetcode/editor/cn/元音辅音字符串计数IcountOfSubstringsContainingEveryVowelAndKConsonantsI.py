"""
Title: 3305.元音辅音字符串计数 I
Title Slug: countOfSubstringsContainingEveryVowelAndKConsonantsI
Author: Neo
Date: 2025-03-12 11:09:45
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def f(self, word: str, k: int) -> int:
        cnt1 = defaultdict(int)
        ans = cnt2 = left = 0
        for b in word:
            if b in "aeiou":
                cnt1[b] += 1
            else:
                cnt2 += 1
            while len(cnt1) == 5 and cnt2 >= k:
                out = word[left]
                if out in "aeiou":
                    cnt1[out] -= 1
                    if cnt1[out] == 0:
                        del cnt1[out]
                else:
                    cnt2 -= 1
                left += 1
            ans += left
        return ans

    def countOfSubstrings(self, word: str, k: int) -> int:
        return self.f(word, k) - self.f(word, k + 1)

# leetcode submit region end(Prohibit modification and deletion)
