"""
Title: 3170.删除星号以后字典序最小的字符串
Title Slug: lexicographicallyMinimumStringAfterRemovingStars
Author: Neo
Date: 2025-06-07 18:32:26
"""
from collections import deque


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def clearStars(self, s: str) -> str:
        s = list(s)
        flg = "*"
        stacks = [[] for _ in range(26)]
        for i, c in enumerate(s):
            if c == flg:
                for st in stacks:
                    if st:
                        s[st.pop()] = flg
                        break
            else:
                stacks[ord(c) - ord("a")].append(i)
        return "".join(c for c in s if c != flg)

    # leetcode submit region end(Prohibit modification and deletion)
