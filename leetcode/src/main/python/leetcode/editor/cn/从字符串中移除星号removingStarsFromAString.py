"""
Title: 2390.从字符串中移除星号
Title Slug: removingStarsFromAString
Author: Neo
Date: 2024-09-14 12:08:18
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeStars(self, s: str) -> str:
        st = []
        for c in s:
            if c == '*':
                if st:
                    del st[-1]
            else:
                st.append(c)
        return "".join(st)
# leetcode submit region end(Prohibit modification and deletion)
