"""
Title: LCR 042.最近的请求次数
Title Slug: H8086Q
Author: Neo
Date: 2024-07-05 18:28:43
"""


# leetcode submit region begin(Prohibit modification and deletion)
class RecentCounter:

    def __init__(self):
        self.q = []

    def ping(self, t: int) -> int:
        self.q.append(t)
        while self.q[0] < t - 3000:
            del self.q[0]
        return len(self.q)

# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
# leetcode submit region end(Prohibit modification and deletion)
