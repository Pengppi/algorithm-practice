"""
Title: 3200.三角形的最大高度
Title Slug: maximumHeightOfATriangle
Author: Neo
Date: 2024-10-15 12:59:43
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxHeightOfTriangle(self, red: int, blue: int) -> int:
        def get(x: int, y: int) -> int:
            i = 1
            while True:
                if i % 2 == 1:
                    x -= i
                    if x < 0:
                        return i - 1
                else:
                    y -= i
                    if y < 0:
                        return i - 1
                i += 1

        return max(get(red, blue), get(blue, red))
# leetcode submit region end(Prohibit modification and deletion)
