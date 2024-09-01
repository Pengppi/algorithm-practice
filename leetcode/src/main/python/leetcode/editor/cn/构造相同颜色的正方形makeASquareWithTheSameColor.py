"""
Title: 3127.构造相同颜色的正方形
Title Slug: makeASquareWithTheSameColor
Author: Neo
Date: 2024-08-31 00:44:37
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canMakeSquare(self, grid: List[List[str]]) -> bool:
        n = len(grid)
        pre = [[0] * (n + 1) for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + (1 if grid[i - 1][j - 1] == "B" else 0)
                if i >= 2 and j >= 2:
                    x = abs(pre[i][j] - pre[i - 2][j] - pre[i][j - 2] + pre[i - 2][j - 2])
                    if x != 2:
                        return True
        return False

# leetcode submit region end(Prohibit modification and deletion)
