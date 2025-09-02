"""
Title: 1323.Maximum 69 Number
Title Slug: maximum69Number
Author: Neo
Date: 2025-08-16 11:03:23
"""
from collections import deque


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maximum69Number (self, num: int) -> int:
        s = str(num)
        for i, c in enumerate(s):
            if c == '6':
                return int(s[:i] + '9' + s[i+1:])
        return num
# leetcode submit region end(Prohibit modification and deletion)

