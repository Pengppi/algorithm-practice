"""
Title: 3174.清除数字
Title Slug: clearDigits
Author: Neo
Date: 2024-09-05 13:51:31
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def clearDigits(self, s: str) -> str:
        ans = []
        for c in s:
            if c.isdigit():
                ans.pop()
            else:
                ans.append(c)
        return "".join(ans)
# leetcode submit region end(Prohibit modification and deletion)
