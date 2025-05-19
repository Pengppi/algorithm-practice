"""
Title: 3335.字符串转换后的长度 I
Title Slug: totalCharactersInStringAfterTransformationsI
Author: Neo
Date: 2025-05-13 18:35:16
"""
from functools import cache

# leetcode submit region begin(Prohibit modification and deletion)
z = ord("z")
a = ord("a")
b = ord("b")
mod = 10 ** 9 + 7


@cache
def get(i, t):
    nt = t - (z - i)
    if nt <= 0:
        return 1
    else:
        return (get(a, nt - 1) + get(b, nt - 1)) % mod


class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        ans = 0
        for c in s:
            ans += get(ord(c), t)
            ans %= mod
        return ans

# leetcode submit region end(Prohibit modification and deletion)
