"""
Title: 2402.Meeting Rooms III
Title Slug: meetingRoomsIii
Author: Neo
Date: 2025-12-27 17:06:16
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict
from typing import List


class Solution:

    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        freq = defaultdict(int)
        meetings.sort()
        unUsed = list(range(n))
        queue = []
        for start, end in meetings:
            while queue and queue[0][0] <= start:
                _, room = heapq.heappop(queue)
                heapq.heappush(unUsed, room)
            if unUsed:
                room = heapq.heappop(unUsed)
                heapq.heappush(queue, (end, room))
            else:
                endTime, room = heapq.heappop(queue)
                heapq.heappush(queue, (endTime + end - start, room))
            freq[room] += 1

        return max(freq, key=freq.get)


# leetcode submit region end(Prohibit modification and deletion)
