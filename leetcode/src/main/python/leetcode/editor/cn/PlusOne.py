"""
Title: 66.Plus One
Title Slug: plusOne
Author: Neo
Date: 2026-01-01 15:39:38
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        add = 1
        n = len(digits)
        i = n - 1
        while i >= 0 and add > 0:
            digits[i] += add
            add = digits[i] // 10
            digits[i] %= 10
            i -= 1
        if add > 0:
            digits.insert(0, add)
        return digits

# leetcode submit region end(Prohibit modification and deletion)
