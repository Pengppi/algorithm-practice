"""
Title: 3193.统计逆序对的数目
Title Slug: countTheNumberOfInversions
Author: Neo
Date: 2024-06-24 12:50:40
"""
from functools import cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfPermutations(self, n: int, requirements: List[List[int]]) -> int:
        MOD = 10 ** 9 + 7
        req = [-1] * n
        req[0] = 0
        for end, cnt in requirements:
            req[end] = cnt
        if req[0] != 0:
            return 0

        @cache
        def dfs(i: int, j: int) -> int:
            if i == 0:
                return 1
            r = req[i - 1]
            if r >= 0:
                return dfs(i - 1, r) if r <= j <= i + r else 0
            return sum(dfs(i - 1, j - k) for k in range(min(i, j) + 1)) % MOD

        return dfs(n - 1, req[-1])
# leetcode submit region end(Prohibit modification and deletion)
