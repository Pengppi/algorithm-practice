"""
Title: 522.最长特殊序列 II
Title Slug: longestUncommonSubsequenceIi
Author: Neo
Date: 2024-06-17 12:16:54
"""
from collections import Counter
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def isSubSequence(s: str, t: str) -> bool:
            if len(s) > len(t):
                return False
            i, j = 0, 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    i += 1
                j += 1
            return i == len(s)

        strs.sort(key=lambda s: -len(s))
        for i, s in enumerate(strs):
            if all(j == i or not isSubSequence(s, strs[j]) for j in range(len(strs))):
                return len(s)
        return -1

# leetcode submit region end(Prohibit modification and deletion)
