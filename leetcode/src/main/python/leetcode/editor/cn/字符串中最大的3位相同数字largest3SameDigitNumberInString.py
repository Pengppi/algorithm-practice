"""
Title: 2264.字符串中最大的 3 位相同数字
Title Slug: largest3SameDigitNumberInString
Author: Neo
Date: 2025-01-08 12:54:57
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestGoodInteger(self, num: str) -> str:
        ans = ''
        l = 0
        for r in range(len(num)):
            if num[r] == num[l]:
                if r - l + 1 == 3:
                    ans = max(ans, num[l:r + 1])
            else:
                l = r
        return ans

# leetcode submit region end(Prohibit modification and deletion)
