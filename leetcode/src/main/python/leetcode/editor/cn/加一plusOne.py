"""
Title: 66.加一
Title Slug: plusOne
Author: Neo
Date: 2024-05-02 20:29:58
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] < 9:
                digits[i] += 1
                return digits
            digits[i] = 0
        return [1] + digits
# leetcode submit region end(Prohibit modification and deletion)
