"""
Title: 2710.移除字符串中的尾随零
Title Slug: removeTrailingZerosFromAString
Author: Neo
Date: 2024-06-29 01:15:32
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeTrailingZeros(self, num: str) -> str:
        for i in range(len(num) - 1, -1, -1):
            if num[i] != '0':
                return num[:i + 1]
        return ""
# leetcode submit region end(Prohibit modification and deletion)
