"""
Title: 3298.统计重新排列后包含另一个字符串的子字符串数目 II
Title Slug: countSubstringsThatCanBeRearrangedToContainAStringIi
Author: Neo
Date: 2025-01-10 18:33:09
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def validSubstringCount(self, word1: str, word2: str) -> int:
        if len(word2) > len(word1):
            return 0
        diff = defaultdict(int)
        for c in word2:
            diff[c] += 1

        lack = len(diff)
        ans = l = 0
        for c in word1:
            diff[c] -= 1
            if diff[c] == 0:
                lack -= 1
            while lack == 0:
                diff[word1[l]] += 1
                if diff[word1[l]] > 0:
                    lack += 1
                l += 1
            ans += l
        return ans
# leetcode submit region end(Prohibit modification and deletion)
