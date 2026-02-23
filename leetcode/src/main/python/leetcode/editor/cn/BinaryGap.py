"""
Title: 868.Binary Gap
Title Slug: binaryGap
Author: Neo
Date: 2026-02-22 11:21:14
"""

# leetcode submit region begin(Prohibit modification and deletion)


class Solution:
    def binaryGap(self, n: int) -> int:
        last, ans, i = -1, 0, 0
        while n:
            if n & 1:
                if last > -1:
                    ans = max(ans, i - last)
                last = i
            i += 1
            n >>= 1
        return ans


# leetcode submit region end(Prohibit modification and deletion)
