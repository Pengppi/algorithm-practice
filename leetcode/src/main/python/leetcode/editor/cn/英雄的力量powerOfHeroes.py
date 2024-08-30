"""
Title: 2681.英雄的力量
Title Slug: powerOfHeroes
Author: Neo
Date: 2024-08-29 20:32:16
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def sumOfPower(self, nums: List[int]) -> int:
        mod = 10 ** 9 + 7
        n = len(nums)
        nums.sort()
        ans = 0
        f = [0] * n
        pre = [0] * (n + 1)
        for i, x in enumerate(nums):
            f[i] = (x + pre[i]) % mod
            pre[i + 1] = (pre[i] + f[i]) % mod
            ans = (ans + x * x * f[i]) % mod

        return ans
# leetcode submit region end(Prohibit modification and deletion)
