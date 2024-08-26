"""
Title: 3146.两个字符串的排列差
Title Slug: permutationDifferenceBetweenTwoStrings
Author: Neo
Date: 2024-08-24 10:47:05
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        mp = {ch: idx for idx, ch in enumerate(s)}

        return sum(abs(mp[ch] - idx) for idx, ch in enumerate(t))
# leetcode submit region end(Prohibit modification and deletion)
