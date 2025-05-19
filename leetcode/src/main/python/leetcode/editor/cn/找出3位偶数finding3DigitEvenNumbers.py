"""
Title: 2094.找出 3 位偶数
Title Slug: finding3DigitEvenNumbers
Author: Neo
Date: 2025-05-12 13:00:45
"""
from itertools import permutations
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findEvenNumbers(self, digits: List[int]) -> List[int]:
        cnt = [0] * 10
        for x in digits:
            cnt[x] += 1

        ans = []

        def dfs(i, x):
            if i == 3:
                ans.append(x)
                return
            for d, c in enumerate(cnt):
                if c <= 0:
                    continue
                if i == 0 and d == 0:
                    continue
                if i == 2 and d % 2 == 1:
                    continue
                cnt[d] -= 1
                dfs(i + 1, x * 10 + d)
                cnt[d] += 1

        dfs(0, 0)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
