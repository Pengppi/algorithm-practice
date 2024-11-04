"""
Title: 3216.交换后字典序最小的字符串
Title Slug: lexicographicallySmallestStringAfterASwap
Author: Neo
Date: 2024-10-30 12:48:46
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getSmallestString(self, s: str) -> str:
        n = len(s)
        s = list(s)
        last = int(s[0])
        for i in range(1, n):
            cur = int(s[i])
            if last & 1 == cur & 1 and last > cur:
                s[i - 1], s[i] = s[i], s[i - 1]
                break
            else:
                last = cur
        return "".join(s)
# leetcode submit region end(Prohibit modification and deletion)
