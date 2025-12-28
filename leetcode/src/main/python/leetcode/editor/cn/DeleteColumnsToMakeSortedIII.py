"""
Title: 960.Delete Columns to Make Sorted III
Title Slug: deleteColumnsToMakeSortedIii
Author: Neo
Date: 2025-12-22 15:57:09
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def minDeletionSize(self, strs: List[str]) -> int:
        n, m = len(strs), len(strs[0])
        f = [0] * m
        for i in range(m):
            for j in range(i):
                if f[j] > f[i] and all(s[j] <= s[i] for s in strs):
                    f[i] = f[j]
            f[i] += 1
        return m - max(f)


# leetcode submit region end(Prohibit modification and deletion)
