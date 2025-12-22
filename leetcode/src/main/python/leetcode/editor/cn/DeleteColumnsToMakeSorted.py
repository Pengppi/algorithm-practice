"""
Title: 944.Delete Columns to Make Sorted
Title Slug: deleteColumnsToMakeSorted
Author: Neo
Date: 2025-12-20 17:59:51
"""

# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def minDeletionSize(self, strs: List[str]) -> int:
        m, n = len(strs), len(strs[0])
        ans = 0
        for j in range(n):
            last = strs[0][j]
            for i in range(1, m):
                if strs[i][j] < last:
                    ans += 1
                    break
                last = strs[i][j]
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().minDeletionSize(["rrjk","furt","guzm"])