"""
Title: 3531.Count Covered Buildings
Title Slug: countCoveredBuildings
Author: Neo
Date: 2025-12-11 10:32:03
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict
from typing import List

from sortedcontainers import SortedList


class Solution:

    def countCoveredBuildings(self, n: int, buildings: List[List[int]]) -> int:

        x_dict = defaultdict(SortedList)
        y_dict = defaultdict(SortedList)
        ans = 0
        for x, y in buildings:
            x_dict[x].add(y)
            y_dict[y].add(x)
        for x, y in buildings:
            k = x_dict[x].bisect_left(y)
            if k == 0 or k >= len(x_dict[x]) - 1:
                continue
            k = y_dict[y].bisect_left(x)
            if k == 0 or k >= len(y_dict[y]) - 1:
                continue
            ans += 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)

Solution().countCoveredBuildings(3, [[1, 1], [1, 2], [2, 1], [2, 2]])
