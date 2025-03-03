"""
Title: 131.分割回文串
Title Slug: palindromePartitioning
Author: Neo
Date: 2025-03-01 23:35:59
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []

        def dfs(i, path):
            if i == len(s):
                ans.append(path[:])
                return
            for j in range(i, len(s)):
                if s[i:j + 1] == s[i:j + 1][::-1]:
                    path.append(s[i:j + 1])
                    dfs(j + 1, path)
                    path.pop()

        dfs(0, [])
        return ans
# leetcode submit region end(Prohibit modification and deletion)
