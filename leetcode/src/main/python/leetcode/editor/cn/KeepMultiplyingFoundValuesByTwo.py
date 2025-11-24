"""
Title: 2154.Keep Multiplying Found Values by Two
Title Slug: keepMultiplyingFoundValuesByTwo
Author: Neo
Date: 2025-11-19 12:28:00
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findFinalValue(self, nums: List[int], original: int) -> int:
        st = set(nums)
        while original in st:
            original <<= 1
        return original

# leetcode submit region end(Prohibit modification and deletion)
