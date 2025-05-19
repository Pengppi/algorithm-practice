"""
Title: 2900.最长相邻不相等子序列 I
Title Slug: longestUnequalAdjacentGroupsSubsequenceI
Author: Neo
Date: 2025-05-15 12:57:25
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        n = len(words)
        ans = list()
        for i, c in enumerate(groups):
            if i == n - 1 or c != groups[i + 1]:
                ans.append(words[i])
        return ans

# leetcode submit region end(Prohibit modification and deletion)
