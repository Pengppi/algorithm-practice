"""
Title: 3226.使两个整数相等的位更改次数
Title Slug: numberOfBitChangesToMakeTwoIntegersEqual
Author: Neo
Date: 2024-11-02 15:24:53
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minChanges(self, n: int, k: int) -> int:
        if n & k != k:
            return -1
        return n.bit_count() - k.bit_count()
# leetcode submit region end(Prohibit modification and deletion)
