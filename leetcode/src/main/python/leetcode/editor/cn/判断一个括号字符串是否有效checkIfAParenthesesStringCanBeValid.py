"""
Title: 2116.判断一个括号字符串是否有效
Title Slug: checkIfAParenthesesStringCanBeValid
Author: Neo
Date: 2025-03-23 18:10:01
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        n = len(s)
        if n & 1:
            return False
        mn = mx = 0
        for i in range(n):
            if locked[i] == '0':
                mn -= 1
                mx += 1
            else:
                d = 1 if s[i] == '(' else -1
                mx += d
                if mx < 0:
                    return False
                mn += d
            if mn < 0:
                mn = 1 # 不能减一，只能加一
        return mn == 0

    # leetcode submit region end(Prohibit modification and deletion)
