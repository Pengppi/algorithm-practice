"""
Title: 3240.最少翻转次数使二进制矩阵回文 II
Title Slug: minimumNumberOfFlipsToMakeBinaryGridPalindromicIi
Author: Neo
Date: 2024-11-16 14:55:49
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0]),
        ans = 0
        for i in range(m // 2):
            g1 = grid[i]
            g2 = grid[-1 - i]
            for j in range(n // 2):
                cnt = g1[j] + g1[-1 - j] + g2[j] + g2[-1 - j]
                ans += min(cnt, 4 - cnt)

        if m & 1 and n & 1:
            ans += grid[m // 2][n // 2]

        diff = cnt1 = 0
        if m & 1:
            row = grid[m // 2]
            for j in range(n // 2):
                if row[j] != row[-1 - j]:
                    diff += 1
                else:
                    cnt1 += row[j] * 2
        if n & 1:
            for i in range(m // 2):
                if grid[i][n // 2] != grid[-1 - i][n // 2]:
                    diff += 1
                else:
                    cnt1 += grid[i][n // 2] * 2

        return ans + (diff if diff else cnt1 % 4)
# leetcode submit region end(Prohibit modification and deletion)
