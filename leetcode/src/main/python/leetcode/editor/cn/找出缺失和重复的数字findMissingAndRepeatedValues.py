"""
Title: 2965.找出缺失和重复的数字
Title Slug: findMissingAndRepeatedValues
Author: Neo
Date: 2024-05-31 22:44:59
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        n = len(grid)
        mx = n * n
        tot_sum = (1 + mx) * mx // 2
        sum = 0
        a = -1
        visted = set()
        for row in grid:
            for x in row:
                if x in visted:
                    a = x
                else:
                    visted.add(x)
                    sum += x
        b = tot_sum - sum
        return [a, b]
# leetcode submit region end(Prohibit modification and deletion)
