"""
Title: 3128.直角三角形
Title Slug: rightTriangles
Author: Neo
Date: 2024-08-02 12:27:55
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfRightTriangles(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        tot_col = [0] * n
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    tot_col[j] += 1

        for i in range(m):
            left = 0
            for j in range(n):
                if grid[i][j] == 1:
                    ans += left * (tot_col[j] - 1)
                    left += 1

        for i in range(m - 1, -1, -1):
            right = 0
            for j in range(n - 1, -1, -1):
                if grid[i][j] == 1:
                    ans += right * (tot_col[j] - 1)
                    right += 1
        return ans

    # leetcode submit region end(Prohibit modification and deletion)
