"""
Title: 3459.Length of Longest V-Shaped Diagonal Segment
Title Slug: lengthOfLongestVShapedDiagonalSegment
Author: Neo
Date: 2025-08-27 12:35:41
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def lenOfVDiagonal(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [-1, -1, 1, 1, -1]

        @cache
        def dfs(x, y, k, flg, target):
            i, j = x + dirs[k], y + dirs[k + 1]
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] != target:
                return 0
            next_target = 0 if target == 2 else 2
            res = dfs(i, j, k, flg, next_target)
            if flg:
                res = max(res, dfs(i, j, (k + 1) % 4, False, next_target))
            return res + 1

        ans = 0
        for i, row in enumerate(grid):
            for j, x in enumerate(row):
                if x == 1:
                    ans = max(ans, 1 + max(dfs(i, j, k, True, 2) for k in range(4)))
        return ans

# leetcode submit region end(Prohibit modification and deletion)
