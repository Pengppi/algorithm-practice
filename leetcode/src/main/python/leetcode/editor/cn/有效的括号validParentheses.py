"""
Title: 20.有效的括号
Title Slug: validParentheses
Author: Neo
Date: 2024-05-02 22:03:00
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def isValid(self, s: str) -> bool:
        stack = list()
        for c in s:
            if c == ')':
                if len(stack) == 0 or stack.pop() != '(':
                    return False
            elif c == '}':
                if len(stack) == 0 or stack.pop() != '{':
                    return False
            elif c == ']':
                if len(stack) == 0 or stack.pop() != '[':
                    return False
            else:
                stack.append(c)

        return len(stack) == 0
# leetcode submit region end(Prohibit modification and deletion)
