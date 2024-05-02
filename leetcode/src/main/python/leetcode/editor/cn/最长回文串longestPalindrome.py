"""
Title: 409.最长回文串
Title Slug: longestPalindrome
Author: Neo
Date: 2024-05-02 23:39:34
"""
import collections


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        ans = 0
        count = collections.Counter(s)
        for v in count.values():
            ans += v // 2 * 2
            if ans % 2 == 0 and v % 2 == 1:
                ans += 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
