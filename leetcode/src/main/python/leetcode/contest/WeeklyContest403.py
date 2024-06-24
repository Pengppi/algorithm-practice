from cmath import inf
from functools import cache, lru_cache
from typing import List


class Solution:
    def minimumAverage(self, nums: List[int]) -> float:
        nums.sort()
        n = len(nums)
        ans = inf
        i = 0
        while i * 2 < n:
            ans = min(ans, (nums[i] + nums[n - 1 - i]) / 2)
            i += 1
        return ans

    def minimumArea(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        l, r, u, d = inf, 0, inf, 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    l = min(l, j)
                    r = max(r, j)
                    u = min(u, i)
                    d = max(d, i)
        return (r - l + 1) * (d - u + 1)

    def maximumTotalCost(self, nums: List[int]) -> int:
        n = len(nums)

        @lru_cache(None)
        def dfs(i: int, p: int) -> int:
            if i == n:
                return 0
            res = dfs(i + 1, -1) + nums[i]
            if nums[i] >= 0:
                return res
            if p < 0:
                res = max(res, dfs(i + 1, 1) - nums[i])
            return res

        return dfs(0, 1)
