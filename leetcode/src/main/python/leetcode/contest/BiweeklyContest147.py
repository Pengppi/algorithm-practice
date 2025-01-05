import heapq
import re
from bisect import bisect
from cmath import inf
from collections import defaultdict
from functools import cache
from typing import List

from sortedcontainers import SortedDict, SortedList


class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        n = len(nums)

        mp = defaultdict(list)
        for i, x in enumerate(nums):
            mp[x].append(i)

        @cache
        def find(l, last):
            if l >= n - 1:
                return 0
            res = 0

            for x in range(nums[l] - last, nums[l] + last + 1):
                if x not in mp:
                    continue
                j = bisect.bisect_left(mp[x], l + 1)
                if j < len(mp[x]):
                    res = max(res, find(mp[x][j], abs(nums[l] - x)) + 1)
            return res

        ans = 0
        for i in range(n - 1):
            if n - i <= ans:
                break
            ans = max(ans, find(i, 1000) + 1)

        return ans

    def hasMatch(self, s: str, p: str) -> bool:
        np = ".*" + p.replace("*", ".*") + ".*"
        if re.fullmatch(np, s):
            return True
        return False


class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        q = SortedDict()
        tu = defaultdict(list)
        for userId, taskId, priority in tasks:
            q[priority] = SortedList()
            q[priority].add(taskId)
            tu[taskId].append((priority, userId))
        self.q = q
        self.tu = tu

    def add(self, userId: int, taskId: int, priority: int) -> None:
        if priority not in self.q:
            self.q[priority] = SortedList()
        self.q[priority].add(taskId)
        self.tu[taskId] = [priority, userId]

    def edit(self, taskId: int, newPriority: int) -> None:
        self.rmv(taskId)
        self.add(self.tu[taskId][1], taskId, newPriority)

    def rmv(self, taskId: int) -> None:
        oldPriority = self.tu[taskId][0]
        self.q[oldPriority].discard(taskId)
        del self.tu[taskId]

    def execTop(self) -> int:
        q = self.q
        while len(q.peekitem(-1)) == 0:
            q.popitem(-1)
        taskId = q.peekitem(-1)[-1]
        userId = self.tu[taskId][1]
        self.rmv(taskId)
        return userId
