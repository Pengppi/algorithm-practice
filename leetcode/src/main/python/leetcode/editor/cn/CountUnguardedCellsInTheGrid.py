"""
Title: 2257.Count Unguarded Cells in the Grid
Title Slug: countUnguardedCellsInTheGrid
Author: Neo
Date: 2025-11-02 21:31:38
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        dirs = [0, -1, 0, 1, 0]
        guards_set = {(x, y) for x, y in guards}
        walls_set = {(x, y) for x, y in walls}

        @cache
        def is_guard(x: int, y: int, k: int) -> bool:
            if x < 0 or x >= m or y < 0 or y >= n:
                return True
            if (x, y) in walls_set:
                return True
            if (x, y) in guards_set:
                return False
            return is_guard(x + dirs[k], y + dirs[k + 1], k)

        count = 0
        for x in range(m):
            for y in range(n):
                is_unguarded = True
                for k in range(4):
                    if not is_guard(x, y, k):
                        is_unguarded = False
                        break
                if is_unguarded:
                    count += 1
        return count - len(walls_set)

# leetcode submit region end(Prohibit modification and deletion)
