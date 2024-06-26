"""
Title: 2732.找到矩阵中的好子集
Title Slug: findAGoodSubsetOfTheMatrix
Author: Neo
Date: 2024-06-25 11:09:15
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def goodSubsetofBinaryMatrix(self, grid: List[List[int]]) -> List[int]:
        m, n = len(grid), len(grid[0])
        mp = dict()
        for i in range(m):
            mask = 0
            for j in range(n):
                mask |= grid[i][j] << j
            if mask == 0:
                return [i]
            if mask not in mp:
                for (k, v) in mp.items():
                    if k & mask == 0:
                        return [v, i]
            mp[mask] = i
        return []

# leetcode submit region end(Prohibit modification and deletion)
