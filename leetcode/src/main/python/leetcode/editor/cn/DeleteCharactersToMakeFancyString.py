"""
Title: 1957.Delete Characters to Make Fancy String
Title Slug: deleteCharactersToMakeFancyString
Author: Neo
Date: 2025-07-21 17:22:00
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def makeFancyString(self, s: str) -> str:
        ans = []
        for c in s:
            if len(ans) >=2 and ans[-1] ==ans[-2] == c:
                continue
            ans.append(c)
        return "".join(ans)
        
# leetcode submit region end(Prohibit modification and deletion)

