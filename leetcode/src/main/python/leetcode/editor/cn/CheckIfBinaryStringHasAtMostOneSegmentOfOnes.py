"""
Title: 1784.Check if Binary String Has at Most One Segment of Ones
Title Slug: checkIfBinaryStringHasAtMostOneSegmentOfOnes
Author: Neo
Date: 2026-03-06 12:48:55
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        leftOne = s.find("1")
        rightOne = s.rfind("1")
        leftZero = s.find("0")
        if leftOne < leftZero < rightOne:
            return False
        return True


# leetcode submit region end(Prohibit modification and deletion)
