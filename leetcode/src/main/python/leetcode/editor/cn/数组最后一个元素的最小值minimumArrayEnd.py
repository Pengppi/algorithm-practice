"""
Title: 3133.数组最后一个元素的最小值
Title Slug: minimumArrayEnd
Author: Neo
Date: 2024-05-13 23:32:07
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minEnd(self, n: int, x: int) -> int:
        t = n - 1
        i, j = 0, 0
        while (1 << j) <= t:
            while (x >> i) & 1 == 1:
                i += 1
            if (t >> j) & 1 == 1:
                x |= 1 << i

            i += 1
            j += 1
        return x
# leetcode submit region end(Prohibit modification and deletion)
