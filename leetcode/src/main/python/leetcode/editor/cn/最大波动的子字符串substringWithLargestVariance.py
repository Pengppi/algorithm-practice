"""
Title: 2272.最大波动的子字符串
Title Slug: substringWithLargestVariance
Author: Neo
Date: 2025-03-16 18:39:50
"""
from cmath import inf
from itertools import permutations
from string import ascii_lowercase


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestVariance(self, s: str) -> int:
        ans = 0

        for a, b in permutations(ascii_lowercase, 2):
            f0 = 0
            f1 = -inf
            for c in s:
                if c == a:
                    f0 = max(f0, 0) + 1
                    f1 += 1
                if c == b:
                    f1 = f0 = max(f0, 0) - 1

                ans = max(ans, f1)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
