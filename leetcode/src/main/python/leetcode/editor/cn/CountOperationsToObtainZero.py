"""
Title: 2169.Count Operations to Obtain Zero
Title Slug: countOperationsToObtainZero
Author: Neo
Date: 2025-11-09 21:56:47
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def countOperations(self, num1: int, num2: int) -> int:
        ans = 0
        while num1 != 0 and num2 != 0:
            if num1 >= num2:
                k = num1 // num2
                num1 -= num2 * k
            else:
                k = num2 // num1
                num2 -= num1 * k

            ans += k

        return ans
# leetcode submit region end(Prohibit modification and deletion)
