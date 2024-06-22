"""
Title: 2663.字典序最小的美丽字符串
Title Slug: lexicographicallySmallestBeautifulString
Author: Neo
Date: 2024-06-22 10:02:22
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestBeautifulString(self, s: str, k: int) -> str:
        k += ord('a')
        s = list(map(ord, s))
        n = len(s)
        i = n - 1
        s[i] += 1
        while i < n:
            if s[i] >= k:
                if i == 0:
                    return ""
                s[i] = ord('a')
                i -= 1
                s[i] += 1
            elif i > 0 and s[i] == s[i - 1] or i > 1 and s[i] == s[i - 2]:
                s[i] += 1
            else:
                i += 1

        return "".join(map(chr, s))
# leetcode submit region end(Prohibit modification and deletion)
