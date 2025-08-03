"""
Title: 2481.Minimum Cuts to Divide a Circle
Title Slug: minimumCutsToDivideACircle
Author: Neo
Date: 2025-07-31 15:54:43
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfCuts(self, n: int) -> int:
        return n if n > 1 and n & 1 else n // 2

# leetcode submit region end(Prohibit modification and deletion)
