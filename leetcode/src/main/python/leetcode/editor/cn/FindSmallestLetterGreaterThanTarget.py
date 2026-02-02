"""
Title: 744.Find Smallest Letter Greater Than Target
Title Slug: findSmallestLetterGreaterThanTarget
Author: Neo
Date: 2026-01-31 12:41:47
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        for c in letters:
            if c > target:
                return c
        return letters[0]
# leetcode submit region end(Prohibit modification and deletion)

