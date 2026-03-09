"""
Title: 1758.Minimum Changes To Make Alternating Binary String
Title Slug: minimumChangesToMakeAlternatingBinaryString
Author: Neo
Date: 2026-03-05 12:32:17
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minOperations(self, s: str) -> int:
        def calcDiff(origin: str, target: str) -> int:
            op = 0
            for o, t in zip(origin, target):
                if o != t:
                    op += 1
            return op

        n = len(s)
        target1 = "01" * (n // 2 + n % 2)
        target2 = "10" * (n // 2 + n % 2)
        return min(calcDiff(s, target1), calcDiff(s, target2))


# leetcode submit region end(Prohibit modification and deletion)
