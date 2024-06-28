"""
Title: 2734.执行子串操作后的字典序最小字符串
Title Slug: lexicographicallySmallestStringAfterSubstringOperation
Author: Neo
Date: 2024-06-27 00:09:01
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestString(self, s: str) -> str:
        i, n = 0, len(s)
        while i < n and s[i] == 'a':
            i += 1
        if i == n:
            return s[:-1] + 'z'
        ans = s[:i]
        while i < n:
            if s[i] == 'a':
                ans += s[i:]
                break
            ans += chr(ord(s[i]) - 1)
            i += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
