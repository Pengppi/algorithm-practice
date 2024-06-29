"""
Title: 344.反转字符串
Title Slug: reverseString
Author: Neo
Date: 2024-06-29 11:41:57
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        l, r = 0, len(s) - 1
        while l < r:
            s[l], s[r] = s[r], s[l]
            l += 1
            r -= 1
# leetcode submit region end(Prohibit modification and deletion)
