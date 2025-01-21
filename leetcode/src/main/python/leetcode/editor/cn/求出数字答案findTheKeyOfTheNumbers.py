"""
Title: 3270.求出数字答案
Title Slug: findTheKeyOfTheNumbers
Author: Neo
Date: 2025-01-11 15:14:21
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def generateKey(self, x: int, y: int, z: int) -> int:
        ans = 0
        pow10 = 1
        while x and y and z:
            ans += min(x % 10, y % 10, z % 10) * pow10
            x //= 10
            y //= 10
            z //= 10
            pow10 *= 10
        return ans
# leetcode submit region end(Prohibit modification and deletion)


Solution().generateKey(987,879,798)