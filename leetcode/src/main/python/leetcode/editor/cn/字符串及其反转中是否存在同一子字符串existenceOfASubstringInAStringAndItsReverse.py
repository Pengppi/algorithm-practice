"""
Title: 3083.字符串及其反转中是否存在同一子字符串
Title Slug: existenceOfASubstringInAStringAndItsReverse
Author: Neo
Date: 2024-12-26 13:00:55
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        st = set()
        n = len(s)
        for i in range(n - 1):
            cur = s[i:i + 2]
            if cur in st:
                return True
            rever = cur[::-1]
            if cur == rever:
                return True
            st.add(rever)
        return False
# leetcode submit region end(Prohibit modification and deletion)
