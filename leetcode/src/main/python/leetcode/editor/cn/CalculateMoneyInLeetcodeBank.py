"""
Title: 1716.Calculate Money in Leetcode Bank
Title Slug: calculateMoneyInLeetcodeBank
Author: Neo
Date: 2025-10-25 15:04:36
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def totalMoney(self, n: int) -> int:
        ans = 0
        i = 1
        j = 0
        for _ in range(n):
            ans += i + j
            j += 1
            if j % 7 == 0:
                j = 0
                i += 1

        return ans
# leetcode submit region end(Prohibit modification and deletion)
