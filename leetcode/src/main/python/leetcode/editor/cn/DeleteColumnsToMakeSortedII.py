"""
Title: 955.Delete Columns to Make Sorted II
Title Slug: deleteColumnsToMakeSortedIi
Author: Neo
Date: 2025-12-21 11:57:24
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def minDeletionSize(self, strs: List[str]) -> int:
        m, n = len(strs), len(strs[0])
        ans = 0
        a = [''] * m
        for j in range(n):
            for i in range(1, m):
                if a[i - 1] + strs[i - 1][j] > a[i] + strs[i][j]:
                    ans += 1
                    break
            else:
                for i in range(m):
                    a[i] += strs[i][j]
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().minDeletionSize(["xc", "yb", "za"])
