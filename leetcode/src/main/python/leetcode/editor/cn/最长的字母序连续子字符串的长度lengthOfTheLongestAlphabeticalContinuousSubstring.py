"""
Title: 2414.最长的字母序连续子字符串的长度
Title Slug: lengthOfTheLongestAlphabeticalContinuousSubstring
Author: Neo
Date: 2024-09-19 12:50:48
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        n = len(s)
        f = [1] * n
        ans = 1
        for i in range(1, n):
            diff = ord(s[i]) - ord(s[i - 1])
            if diff == 1:
                f[i] = 1 + f[i - 1]
            ans = max(ans, f[i])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
