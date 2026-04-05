"""
Title: 2840.Check if Strings Can be Made Equal With Operations II
Title Slug: checkIfStringsCanBeMadeEqualWithOperationsIi
Author: Neo
Date: 2026-03-30 10:24:52
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def checkStrings(self, s1: str, s2: str) -> bool:
        return sorted(s1[::2]) == sorted(s2[::2]) and sorted(s1[1::2]) == sorted(s2[1::2])
# leetcode submit region end(Prohibit modification and deletion)
