"""
Title: 3242.设计相邻元素求和服务
Title Slug: designNeighborSumService
Author: Neo
Date: 2024-11-09 10:34:21
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class NeighborSum:

    def __init__(self, grid: List[List[int]]):
        n = len(grid)
        adj = defaultdict(int)
        diag = defaultdict(int)
        d1 = [0, -1, 0, 1, 0]
        d2 = [-1, -1, 1, 1, -1]
        for i, row in enumerate(grid):
            for j, val in enumerate(row):
                for k in range(4):
                    x = i + d1[k]
                    y = j + d1[k + 1]
                    if 0 <= x < n and 0 <= y < n:
                        adj[val] += grid[x][y]
                    x = i + d2[k]
                    y = j + d2[k + 1]
                    if 0 <= x < n and 0 <= y < n:
                        diag[val] += grid[x][y]

        self.adj = adj
        self.diag = diag

    def adjacentSum(self, value: int) -> int:
        return self.adj[value]

    def diagonalSum(self, value: int) -> int:
        return self.diag[value]

# Your NeighborSum object will be instantiated and called as such:
# obj = NeighborSum(grid)
# param_1 = obj.adjacentSum(value)
# param_2 = obj.diagonalSum(value)
# leetcode submit region end(Prohibit modification and deletion)
