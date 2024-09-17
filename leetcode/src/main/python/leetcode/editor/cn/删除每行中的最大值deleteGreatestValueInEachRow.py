"""
Title: 2500.删除每行中的最大值
Title Slug: deleteGreatestValueInEachRow
Author: Neo
Date: 2024-09-17 16:54:18
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def deleteGreatestValue(self, grid: List[List[int]]) -> int:
        ans = 0
        for row in grid:
            row.sort()
        for j in range(len(grid[0])):
            max_val = 0
            for i in range(len(grid)):
                max_val = max(max_val, grid[i][j])
            ans += max_val
        return ans

# leetcode submit region end(Prohibit modification and deletion)
