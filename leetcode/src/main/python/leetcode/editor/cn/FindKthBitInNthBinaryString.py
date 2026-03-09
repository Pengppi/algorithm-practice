"""
Title: 1545.Find Kth Bit in Nth Binary String
Title Slug: findKthBitInNthBinaryString
Author: Neo
Date: 2026-03-03 11:16:36
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findKthBit(self, n: int, k: int) -> str:

        def invertAndReverse(s: str) -> str:
            res = ["1" if c == "0" else "0" for c in s]
            return "".join(res[::-1])

        s = "0"
        for i in range(2, n + 1):
            ns = s + "1" + invertAndReverse(s)
            s = ns

        return s[k - 1]


# leetcode submit region end(Prohibit modification and deletion)
