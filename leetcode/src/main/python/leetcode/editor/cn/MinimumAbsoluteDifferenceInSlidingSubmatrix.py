"""
Title: 3567.Minimum Absolute Difference in Sliding Submatrix
Title Slug: minimumAbsoluteDifferenceInSlidingSubmatrix
Author: Neo
Date: 2026-03-20 18:45:33
"""

# leetcode submit region begin(Prohibit modification and deletion)
from itertools import pairwise
from typing import List


class Solution:
    def minAbsDiff(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        ans = [[0] * (n - k + 1) for _ in range(m - k + 1)]
        for i in range(m - k + 1):
            for j in range(n - k + 1):
                nums = [grid[x][y] for x in range(i, i + k) for y in range(j, j + k)]
                nums.sort()
                if nums[0] == nums[-1]:
                    continue
                ans[i][j] = min([(b - a) for a, b in pairwise(nums) if a < b])
        return ans


# leetcode submit region end(Prohibit modification and deletion)
