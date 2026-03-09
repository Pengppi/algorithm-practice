"""
Title: 1888.Minimum Number of Flips to Make the Binary String Alternating
Title Slug: minimumNumberOfFlipsToMakeTheBinaryStringAlternating
Author: Neo
Date: 2026-03-07 13:39:01
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minFlips(self, s: str) -> int:
        ans = n = len(s)
        cnt = 0

        for i in range(2 * n - 1):
            if ord(s[i % n]) & 1 == i & 1:
                cnt += 1
            left = i - n + 1
            if left < 0:
                continue
            ans = min(ans, cnt, n - cnt)
            if ord(s[left]) & 1 == left & 1:
                cnt -= 1

        return ans


# leetcode submit region end(Prohibit modification and deletion)
