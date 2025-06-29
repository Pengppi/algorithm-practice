"""
Title: 2311.小于等于 K 的最长二进制子序列
Title Slug: longestBinarySubsequenceLessThanOrEqualToK
Author: Neo
Date: 2025-06-26 19:24:07
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        n, m = len(s), k.bit_length()
        if n < m:
            return n
        ans = m if int(s[-m:], 2) <= k else m - 1
        return ans + s[:-m].count('0')

# leetcode submit region end(Prohibit modification and deletion)
