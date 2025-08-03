"""
Title: 1717.Maximum Score From Removing Substrings
Title Slug: maximumScoreFromRemovingSubstrings
Author: Neo
Date: 2025-07-23 14:58:13
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        a, b = 'a', 'b'
        if y > x:
            a, b = b, a
            x, y = y, x
        cnt1 = cnt2 = ans = 0
        for c in s:
            if c == a:
                cnt1 += 1
            elif c == b:
                if cnt1 > 0:
                    cnt1 -= 1
                    ans += x
                else:
                    cnt2 += 1
            else:
                ans += y * min(cnt1, cnt2)
                cnt1 = cnt2 = 0

        return ans + y * min(cnt1, cnt2)


# leetcode submit region end(Prohibit modification and deletion)
Solution().maximumGain(s="cdbcbbaaabab", x=4, y=5)
