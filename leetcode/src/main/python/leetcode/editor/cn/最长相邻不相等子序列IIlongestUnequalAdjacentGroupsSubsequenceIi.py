"""
Title: 2901.最长相邻不相等子序列 II
Title Slug: longestUnequalAdjacentGroupsSubsequenceIi
Author: Neo
Date: 2025-05-16 20:40:20
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getWordsInLongestSubsequence(self, words: List[str], groups: List[int]) -> List[str]:
        def check(a, b):
            if len(a) != len(b):
                return False
            cnt = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    cnt += 1
                    if cnt > 1:
                        return False
            return True

        n = len(words)
        f = [0] * n
        frm = [0] * n
        mx_i = n - 1
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                if f[j] > f[i] and groups[j] != groups[i] and check(words[i], words[j]):
                    f[i] = f[j]
                    frm[i] = j
            f[i] += 1
            if f[i] > f[mx_i]:
                mx_i = i

        i = mx_i
        ans = [''] * f[i]
        for k in range(f[i]):
            ans[k] = words[i]
            i = frm[i]
        return ans

# leetcode submit region end(Prohibit modification and deletion)
