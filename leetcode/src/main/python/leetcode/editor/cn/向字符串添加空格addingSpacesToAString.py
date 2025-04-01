"""
Title: 2109.向字符串添加空格
Title Slug: addingSpacesToAString
Author: Neo
Date: 2025-03-30 18:30:24
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        spaces.sort()
        ans = []
        j = 0
        for i, c in enumerate(s):
            if j < len(spaces) and i == spaces[j]:
                ans.append(" ")
                j += 1
            ans.append(c)
        return ''.join(ans)

# leetcode submit region end(Prohibit modification and deletion)
