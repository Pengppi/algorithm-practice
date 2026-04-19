"""
Title: 3783.Mirror Distance of an Integer
Title Slug: mirrorDistanceOfAnInteger
Author: Neo
Date: 2026-04-18 15:22:18
"""

# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def mirrorDistance(self, n: int) -> int:
        def reverse(num: int) -> int:
            x = num
            t = 0
            while x > 0:
                t = t * 10 + x % 10
                x //= 10
            return t

        return abs(n - reverse(n))
# leetcode submit region end(Prohibit modification and deletion)

