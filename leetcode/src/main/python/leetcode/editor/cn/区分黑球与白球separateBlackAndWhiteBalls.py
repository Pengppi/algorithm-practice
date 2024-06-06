"""
Title: 2938.区分黑球与白球
Title Slug: separateBlackAndWhiteBalls
Author: Neo
Date: 2024-06-06 14:27:20
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumSteps(self, s: str) -> int:
        l, r = 0, len(s) - 1
        ans = 0
        while l < r:
            while l < r and s[l] == "0":
                l += 1
            while l < r and s[r] == "1":
                r -= 1
            if l >= r:
                break
            ans += r - l
            l += 1
            r -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
