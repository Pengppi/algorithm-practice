"""
Title: 1681.最小不兼容性
Title Slug: minimumIncompatibility
Author: Neo
Date: 2024-12-08 14:32:22
"""
from cmath import inf
from collections import Counter
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumIncompatibility(self, nums: List[int], k: int) -> int:
        if any(c > k for c in Counter(nums).values()):
            return -1
        n = len(nums)
        sz = n // k
        nums.sort()

        @cache
        def dfs(left, prev):
            if left == 0:
                return 0
            if left.bit_count() % sz == 0:
                lb = left & -left
                return dfs(left ^ lb, lb.bit_length() - 1)
            res = inf
            last = nums[prev]
            for i in range(prev + 1, n):
                if left >> i & 1 and nums[i] != last:
                    last = nums[i]
                    res = min(res, last - nums[prev] + dfs(left ^ (1 << i), i))
            return res

        return dfs((1 << n) - 2, 0)

# leetcode submit region end(Prohibit modification and deletion)
