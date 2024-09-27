"""
Title: 2207.字符串中最多数目的子序列
Title Slug: maximizeNumberOfSubsequencesInAString
Author: Neo
Date: 2024-09-24 12:21:35
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximumSubsequenceCount(self, text: str, pattern: str) -> int:
        l_cnt, r_cnt = 0, 0
        ans = 0
        for c in text:
            if c == pattern[1]:
                r_cnt += 1
                ans += l_cnt
            if c == pattern[0]:
                l_cnt += 1
        return max(l_cnt, r_cnt) + ans

# leetcode submit region end(Prohibit modification and deletion)
