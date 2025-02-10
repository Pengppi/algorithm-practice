"""
Title: 59.螺旋矩阵 II
Title Slug: spiralMatrixIi
Author: Neo
Date: 2025-02-07 13:37:15
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        ans = [[0] * n for _ in range(n)]
        dirs = [0, 1, 0, -1, 0]
        k = 0
        x, y = 0, -1
        for i in range(1, n * n + 1):
            nx = x + dirs[k]
            ny = y + dirs[k + 1]
            while nx < 0 or nx >= n or ny < 0 or ny >= n or ans[nx][ny] != 0:
                k = (k + 1) % 4
                nx = x + dirs[k]
                ny = y + dirs[k + 1]
            ans[nx][ny] = i
            x, y = nx, ny

        return ans

# leetcode submit region end(Prohibit modification and deletion)
