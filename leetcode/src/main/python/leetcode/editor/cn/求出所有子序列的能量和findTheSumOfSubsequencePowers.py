"""
Title: 3098.求出所有子序列的能量和
Title Slug: findTheSumOfSubsequencePowers
Author: Neo
Date: 2024-07-23 13:06:45
"""
from cmath import inf
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumOfPowers(self, nums: List[int], k: int) -> int:
        n = len(nums)
        mod = 10 ** 9 + 7
        nums.sort()

        @cache
        def dfs(i: int, sz: int, last: int, mn: int) -> int:
            if sz == k:
                return mn % mod
            if i >= n or sz + n - i < k:
                return 0
            res = dfs(i + 1, sz + 1, nums[i], min(mn, nums[i] - last))
            res += dfs(i + 1, sz, last, mn)
            return res % mod

        return dfs(0, 0, inf // 2, inf)
# leetcode submit region end(Prohibit modification and deletion)
