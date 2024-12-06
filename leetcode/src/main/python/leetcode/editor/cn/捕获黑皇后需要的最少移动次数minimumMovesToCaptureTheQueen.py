"""
Title: 3001.捕获黑皇后需要的最少移动次数
Title Slug: minimumMovesToCaptureTheQueen
Author: Neo
Date: 2024-12-05 12:48:40
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minMovesToCaptureTheQueen(self, a: int, b: int, c: int, d: int, e: int, f: int) -> int:
        def is_between(l, m, r):
            return min(l, r) <= m <= max(l, r)

        if a == e and (c != a or not is_between(b, d, f)):
            return 1
        if b == f and (d != b or not is_between(a, c, e)):
            return 1
        if c + d == e + f and (a + b != e + f or not is_between(c, a, e)) or \
                c - d == e - f and (a - b != e - f or not is_between(c, a, e)):
            return 1
        return 2
# leetcode submit region end(Prohibit modification and deletion)
