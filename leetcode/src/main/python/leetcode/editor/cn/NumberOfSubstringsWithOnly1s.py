"""
Title: 1513.Number of Substrings With Only 1s
Title Slug: numberOfSubstringsWithOnly1s
Author: Neo
Date: 2025-11-16 16:13:43
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numSub(self, s: str) -> int:
        mod = 10 ** 9 + 7
        ans = 0
        l = 0
        for r, c in enumerate(s):
            if c == '0':
                l = r + 1
            else:
                ans += r - l + 1
                ans %= mod
        return ans
# leetcode submit region end(Prohibit modification and deletion)
