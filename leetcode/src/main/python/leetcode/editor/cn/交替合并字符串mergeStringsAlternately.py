"""
Title: 1768.交替合并字符串
Title Slug: mergeStringsAlternately
Author: Neo
Date: 2024-05-10 16:53:45
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        i, j = 0, 0
        ans = ""
        while i < len(word1) and j < len(word2):
            ans += word1[i] + word2[j]
            i += 1
            j += 1
        if i < len(word1):
            ans += word1[i:]
        if j < len(word2):
            ans += word2[j:]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
