"""
Title: 3548.Equal Sum Grid Partition II
Title Slug: equalSumGridPartitionIi
Author: Neo
Date: 2026-03-26 12:28:11
"""

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canPartitionGrid(self, grid: List[List[int]]) -> bool:
        tot = sum([sum(row) for row in grid])

        def check(a: List[List[int]]) -> bool:
            vis: set[int] = set()
            s = 0
            # 排除最后一行
            for i, row in enumerate(a[:-1]):
                s += sum(row)
                t = 2 * s - tot
                if t == 0:
                    return True
                vis.update(row)
                if i == 0:
                    if t == row[0] or t == row[-1]:
                        return True
                elif len(row) == 1:
                    if t == a[0][0] or t == row[0]:
                        return True
                elif t in vis:
                    return True

            return False

        rotated = [list(row) for row in zip(*grid)]
        return (
            check(grid) or check(grid[::-1]) or check(rotated) or check(rotated[::-1])
        )


# leetcode submit region end(Prohibit modification and deletion)
