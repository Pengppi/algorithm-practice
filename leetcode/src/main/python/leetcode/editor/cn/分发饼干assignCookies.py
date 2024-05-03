"""
Title: 455.分发饼干
Title Slug: assignCookies
Author: Neo
Date: 2024-05-03 20:38:32
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        i, j = 0, 0
        g.sort()
        s.sort()
        while j < len(s) and i < len(g):
            if s[j] >= g[i]:
                j += 1
                i += 1
            else:
                j += 1
        return i

# leetcode submit region end(Prohibit modification and deletion)
