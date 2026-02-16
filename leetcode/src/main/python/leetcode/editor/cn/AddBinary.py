"""
Title: 67.Add Binary
Title Slug: addBinary
Author: Neo
Date: 2026-02-15 16:49:28
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        l1, l2 = len(a), len(b)
        add = 0
        ans = []
        while l1 > 0 or l2 > 0 or add > 0:
            if l1 > 0:
                add += ord(a[l1 - 1]) - ord('0')
                l1 -= 1
            if l2 > 0:
                add += ord(b[l2 - 1]) - ord('0')
                l2 -= 1
            ans.insert(0,add % 2)
            add //= 2
        return ''.join(map(str, ans))
# leetcode submit region end(Prohibit modification and deletion)
