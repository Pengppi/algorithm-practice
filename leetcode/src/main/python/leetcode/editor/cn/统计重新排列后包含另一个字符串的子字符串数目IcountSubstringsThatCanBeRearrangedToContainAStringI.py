"""
Title: 3297.统计重新排列后包含另一个字符串的子字符串数目 I
Title Slug: countSubstringsThatCanBeRearrangedToContainAStringI
Author: Neo
Date: 2025-01-09 12:20:26
"""
from collections import defaultdict


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def validSubstringCount(self, word1: str, word2: str) -> int:
        if len(word1) < len(word2):
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
                if diff[word1[l]] == 0:
                    lack += 1
                diff[word1[l]] += 1
                l += 1
            ans += l
        return ans

# leetcode submit region end(Prohibit modification and deletion)
