"""
Title: 3408.Design Task Manager
Title Slug: designTaskManager
Author: Neo
Date: 2025-09-18 12:33:27
"""
import heapq
from collections import defaultdict
from itertools import takewhile
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        task_heap = [(-p, -t, u) for u, t, p in tasks]
        task_map = {t: (p, u) for u, t, p in tasks}
        heapq.heapify(task_heap)
        self.task_heap = task_heap
        self.task_map = task_map

    def add(self, userId: int, taskId: int, priority: int) -> None:
        heapq.heappush(self.task_heap, (-priority, -taskId, userId))
        self.task_map[taskId] = (priority, userId)
 
    def edit(self, taskId: int, newPriority: int) -> None:
        self.add(self.task_map[taskId][1], taskId, newPriority)

    def rmv(self, taskId: int) -> None:
        self.task_map[taskId] = (-1, -1)

    def execTop(self) -> int:
        task_heap = self.task_heap
        while task_heap:
            neg_p, neg_t, u = heapq.heappop(task_heap)
            t = -neg_t
            p = -neg_p
            if self.task_map[t] == (p, u):
                self.rmv(t)
                return u
        return -1

# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()
# leetcode submit region end(Prohibit modification and deletion)
