"""
Title: 1247.Minimum Swaps to Make Strings Equal
Title Slug: minimumSwapsToMakeStringsEqual
Author: Neo
Date: 2025-11-14 20:01:21
"""
from collections import Counter


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumSwap(self, s1: str, s2: str) -> int:
        cnt = Counter(x for x, y in zip(s1, s2) if x != y)
        d = cnt['x'] + cnt['y']
        return -1 if d & 1 else d // 2 + cnt['x'] % 2


# leetcode submit region end(Prohibit modification and deletion)


print(ord('a'))
x = -3
print(x & 1)
