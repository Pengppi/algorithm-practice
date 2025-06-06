"""
Title: 3024.三角形类型
Title Slug: typeOfTriangle
Author: Neo
Date: 2025-05-19 12:32:00
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def triangleType(self, nums: List[int]) -> str:
        nums.sort()
        a, b, c = nums
        if a + b <= c:
            return "none"
        if a == b == c:
            return "equilateral"
        elif a == b or b == c or a == c:
            return "isosceles"
        else:
            return "scalene"
    # leetcode submit region end(Prohibit modification and deletion)
