"""
Title: 2296.设计一个文本编辑器
Title Slug: designATextEditor
Author: Neo
Date: 2025-02-27 13:00:05
"""
from leetcode.entity import ListNode


# leetcode submit region begin(Prohibit modification and deletion)
class TextEditor:

    def __init__(self):
        self.left = []
        self.right = []

    def addText(self, text: str) -> None:
        self.left.extend(text)

    def deleteText(self, k: int) -> int:
        pre_len = len(self.left)
        del self.left[-k:]
        return pre_len - len(self.left)

    def cursorLeft(self, k: int) -> str:
        while k and self.left:
            self.right.append(self.left.pop())
            k -= 1
        return "".join(self.left[-10:])

    def cursorRight(self, k: int) -> str:
        while k and self.right:
            self.left.append(self.right.pop())
            k -= 1
        return "".join(self.left[-10:])


# Your TextEditor object will be instantiated and called as such:
# obj = TextEditor()
# obj.addText(text)
# param_2 = obj.deleteText(k)
# param_3 = obj.cursorLeft(k)
# param_4 = obj.cursorRight(k)
# leetcode submit region end(Prohibit modification and deletion)
