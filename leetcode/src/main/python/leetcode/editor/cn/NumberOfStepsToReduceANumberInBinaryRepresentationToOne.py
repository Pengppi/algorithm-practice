"""
Title: 1404.Number of Steps to Reduce a Number in Binary Representation to One
Title Slug: numberOfStepsToReduceANumberInBinaryRepresentationToOne
Author: Neo
Date: 2026-02-26 11:24:04
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numSteps(self, s: str) -> int:
        x = int(s, 2)
        step = 0
        while x != 1:
            if x & 1:
                x += 1
            else:
                x //= 2
            step += 1

        return step
# leetcode submit region end(Prohibit modification and deletion)
