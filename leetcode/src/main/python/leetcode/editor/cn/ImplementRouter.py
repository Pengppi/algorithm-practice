"""
Title: 3508.Implement Router
Title Slug: implementRouter
Author: Neo
Date: 2025-09-20 11:22:48
"""
import bisect
from collections import defaultdict, deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Router:

    def __init__(self, memoryLimit: int):
        self.limit = memoryLimit
        self.dest_mp = defaultdict(deque)
        self.queue = deque()

    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        q = self.queue
        i = len(q) - 1
        while i >= 0 and q[i][2] == timestamp:
            if q[i][0] == source and q[i][1] == destination:
                return False
            i -= 1
        q.append((source, destination, timestamp))
        self.dest_mp[destination].append(timestamp)
        if len(q) > self.limit:
            self.forwardPacket()
        return True

    def forwardPacket(self) -> List[int]:
        if not self.queue:
            return []
        d = self.queue[0][1]
        self.dest_mp[d].popleft()
        return self.queue.popleft()

    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        time_list = self.dest_mp[destination]
        l = bisect.bisect_left(time_list, startTime)
        r = bisect.bisect_right(time_list, endTime)

        return r - l
# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)
# leetcode submit region end(Prohibit modification and deletion)
# obj = Router(3)
# obj.addPacket(1,4,90)
# obj.addPacket(2,5,90)
# obj.addPacket(1,4,90)
