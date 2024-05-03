"""
Title: 316.去除重复字母
Title Slug: removeDuplicateLetters
Author: Neo
Date: 2024-05-03 22:56:35
"""
import collections


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        stack, left = [], collections.Counter(s)
        in_stack = set()
        for ch in s:
            left[ch] -= 1
            if ch in in_stack:
                continue
            while stack and stack[-1] > ch and left[stack[-1]]:
                in_stack.remove(stack.pop())
            stack.append(ch)
            in_stack.add(ch)
        return "".join(stack)
# leetcode submit region end(Prohibit modification and deletion)
