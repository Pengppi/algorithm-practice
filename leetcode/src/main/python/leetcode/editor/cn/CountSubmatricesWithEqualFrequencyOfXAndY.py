"""
Title: 3212.Count Submatrices With Equal Frequency of X and Y
Title Slug: countSubmatricesWithEqualFrequencyOfXAndY
Author: Neo
Date: 2026-03-19 12:31:59
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        m, n = len(grid), len(grid[0])
        pre_sum = [[[0 for _ in range(2)] for _ in range(n + 1)] for _ in range(m + 1)]
        ans = 0
        for i, row in enumerate(grid):
            for j, x in enumerate(row):
                cur_sum = pre_sum[i + 1][j][0] + pre_sum[i][j + 1][0] - pre_sum[i][j][0]
                if x == "X":
                    cur_sum += 1
                    has_x = 1
                else:
                    has_x = pre_sum[i][j + 1][1] | pre_sum[i + 1][j][1]
                    if x == "Y":
                        cur_sum -= 1
                pre_sum[i + 1][j + 1][0] = cur_sum
                pre_sum[i + 1][j + 1][1] = has_x
                if cur_sum == 0 and has_x:
                    ans += 1

        return ans


# leetcode submit region end(Prohibit modification and deletion)
