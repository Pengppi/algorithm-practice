"""
Title: 3177.求出最长好子序列 II
Title Slug: findTheMaximumLengthOfAGoodSubsequenceIi
Author: Neo
Date: 2024-09-07 16:02:02
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        dp = defaultdict(lambda: [0] * (k + 1))
        mx = [0] * (k + 1)
        for x in nums:
            f = dp[x]
            for j in range(k, -1, -1):
                f[j] += 1
                if j > 0:
                    f[j] = max(f[j], mx[j - 1] + 1)
                mx[j] = max(mx[j], f[j])
        return mx[-1]
        # leetcode submit region end(Prohibit modification and deletion)
