"""
Title: 1845.座位预约管理系统
Title Slug: seatReservationManager
Author: Neo
Date: 2024-09-30 14:21:05
"""
import heapq


# leetcode submit region begin(Prohibit modification and deletion)
class SeatManager:

    def __init__(self, n: int):
        self.q = [x for x in range(1, n + 1)]

    def reserve(self) -> int:
        return heapq.heappop(self.q)

    def unreserve(self, seatNumber: int) -> None:
        heapq.heappush(self.q, seatNumber)

# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)
# leetcode submit region end(Prohibit modification and deletion)
