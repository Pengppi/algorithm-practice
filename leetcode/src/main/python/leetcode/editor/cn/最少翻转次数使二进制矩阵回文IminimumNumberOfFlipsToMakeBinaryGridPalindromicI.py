"""
Title: 3239.最少翻转次数使二进制矩阵回文 I
Title Slug: minimumNumberOfFlipsToMakeBinaryGridPalindromicI
Author: Neo
Date: 2024-11-15 12:26:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        cnt1 = 0
        for i in range(m):
            l, r = 0, n - 1
            while l < r:
                if grid[i][l] != grid[i][r]:
                    cnt1 += 1
                l += 1
                r -= 1
        cnt2 = 0
        for j in range(n):
            l, r = 0, m - 1
            while l < r:
                if grid[l][j] != grid[r][j]:
                    cnt2 += 1
                l += 1
                r -= 1
        return min(cnt1, cnt2)
# leetcode submit region end(Prohibit modification and deletion)
