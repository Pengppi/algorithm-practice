"""
Title: 838.推多米诺
Title Slug: pushDominoes
Author: Neo
Date: 2025-05-02 17:12:04
"""
from os import lstat


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def pushDominoes(self, dominoes: str) -> str:
        s = list('L' + dominoes + 'R')
        last = 0
        for i, c in enumerate(s):
            if c == '.':
                continue
            if c == s[last]:
                s[last + 1:i] = c * (i - last - 1)
            elif c == 'L':
                m = (last + i - 1) // 2
                s[last + 1:m + 1] = 'R' * (m - last)
                m = (i + last) // 2 + 1
                s[m:i] = 'L' * (i - m)
            last = i
        return ''.join(s[1:-1])
# leetcode submit region end(Prohibit modification and deletion)
