"""
Title: 3713.Longest Balanced Substring I
Title Slug: longestBalancedSubstringI
Author: Neo
Date: 2026-02-12 17:06:55
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        ans = 0
        for i in range(n):
            cnt = [0] * 26
            if ans >= n - i:
                break
            for j in range(i, n):
                cnt[ord(s[j]) - 97] += 1

                freq = [c for c in cnt if c > 0]
                if len(set(freq)) == 1:
                    ans = max(ans, j - i + 1)

        return ans
# leetcode submit region end(Prohibit modification and deletion)
