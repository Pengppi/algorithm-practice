"""
Title: 1177.构建回文串检测
Title Slug: canMakePalindromeFromSubstring
Author: Neo
Date: 2024-12-08 14:38:44
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        sum = [[0] * 26]
        for c in s:
            sum.append(sum[-1].copy())
            sum[-1][ord(c) - ord('a')] += 1

        ans = []
        for left, right, k in queries:
            m = 0
            for sl, sr in zip(sum[left], sum[right + 1]):
                m += (sr - sl) % 2
            ans.append(m // 2 <= k)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
