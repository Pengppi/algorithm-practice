"""
Title: 696.Count Binary Substrings
Title Slug: countBinarySubstrings
Author: Neo
Date: 2026-02-19 11:38:07
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        left = 0
        change = -1
        ans = 0
        s+='*'
        for right, c in enumerate(s):
            if change == -1:
                if s[left] != c:
                    change = right
            else:
                if s[change] != c:
                    ans += min(change - left, right - change)
                    left = change
                    change = right
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().countBinarySubstrings("10101")