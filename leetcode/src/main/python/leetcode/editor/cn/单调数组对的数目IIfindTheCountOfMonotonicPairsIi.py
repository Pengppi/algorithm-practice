"""
Title: 3251.单调数组对的数目 II
Title Slug: findTheCountOfMonotonicPairsIi
Author: Neo
Date: 2024-11-29 12:29:02
"""
from itertools import accumulate
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countOfPairs(self, nums: List[int]) -> int:
        n = len(nums)
        m = max(nums)
        mod = 10 ** 9 + 7
        f = [[0] * (m + 1) for _ in range(n)]
        for j in range(nums[0] + 1):
            f[0][j] = 1

        for i in range(1, n):
            s = list(accumulate(f[i - 1]))
            for j in range(nums[i] + 1):
                max_k = j + min(nums[i - 1] - nums[i], 0)
                f[i][j] = s[max_k] % mod if max_k >= 0 else 0
        return sum(f[-1][:nums[-1] + 1]) % mod

# leetcode submit region end(Prohibit modification and deletion)
