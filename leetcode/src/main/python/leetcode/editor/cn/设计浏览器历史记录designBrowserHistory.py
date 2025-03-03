"""
Title: 1472.设计浏览器历史记录
Title Slug: designBrowserHistory
Author: Neo
Date: 2025-02-26 12:17:55
"""


# leetcode submit region begin(Prohibit modification and deletion)
class BrowserHistory:

    def __init__(self, homepage: str):
        self.st = [homepage]
        self.cur = 0

    def visit(self, url: str) -> None:
        self.cur += 1
        del self.st[self.cur:]
        self.st.append(url)

    def back(self, steps: int) -> str:
        self.cur = max(0, self.cur - steps)
        return self.st[self.cur]

    def forward(self, steps: int) -> str:
        self.cur = min(len(self.st) - 1, self.cur + steps)
        return self.st[self.cur]

# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)
# leetcode submit region end(Prohibit modification and deletion)
