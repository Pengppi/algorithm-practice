"""
Title: 394.字符串解码
Title Slug: decodeString
Author: Neo
Date: 2024-05-03 00:47:26
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def decodeString(self, s: str) -> str:
        stack, res, num = [], "", 0
        for c in s:
            if c == '[':
                stack.append([res, num])
                res, num = "", 0
            elif c == ']':
                last_res, cur_num = stack.pop()
                res = last_res + cur_num * res
            elif c.isdigit():
                num = num * 10 + int(c)
            else:
                res += c
        return res
# leetcode submit region end(Prohibit modification and deletion)
