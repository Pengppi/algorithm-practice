"""
Title: 3070.Count Submatrices with Top-Left Element and Sum Less Than k
Title Slug: countSubmatricesWithTopLeftElementAndSumLessThanK
Author: Neo
Date: 2026-03-18 10:03:53
"""

from typing import List

º
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countSubmatrices(self, grid: List[List[int]], k: int) -> int:
        m, n = len(grid), len(grid[0])
        pre_sum = [[0] * (n + 1) for _ in range(m + 1)]
        ans = 0
        for i, row in enumerate(grid):
            for j, x in enumerate(row):
                pre_sum[i + 1][j + 1] = (
                        pre_sum[i + 1][j] + pre_sum[i][j + 1] - pre_sum[i][j] + x
                )
                if pre_sum[i + 1][j + 1] <= k:
                    ans += 1
                else:
                    break

        return ans

# leetcode submit region end(Prohibit modification and deletion)
