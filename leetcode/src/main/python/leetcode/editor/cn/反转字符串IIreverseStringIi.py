"""
Title: 541.反转字符串 II
Title Slug: reverseStringIi
Author: Neo
Date: 2025-01-31 12:07:02
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        s = list(s)
        for i in range(0, len(s), 2 * k):
            s[i:i + k] = s[i:i + k][::-1]

        return "".join(s)

# leetcode submit region end(Prohibit modification and deletion)
