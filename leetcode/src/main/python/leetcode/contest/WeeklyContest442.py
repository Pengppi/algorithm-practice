from ctypes.macholib.dyld import dyld_find
from typing import List


class Solution:
    def maxContainers(self, n: int, w: int, maxWeight: int) -> int:
        cnt = maxWeight // w
        return min(n * n, cnt) * w

    def numberOfComponents(self, properties: List[List[int]], k: int) -> int:
        n = len(properties)
        setList = [set(row) for row in properties]
        pa = [i for i in range(n)]
        cnt = n

        def find(x):
            if pa[x] != x:
                pa[x] = find(pa[x])
            return pa[x]

        def union(x, y):
            x, y = find(x), find(y)
            if x != y:
                pa[x] = y
                nonlocal cnt
                cnt -= 1

        for i, st in enumerate(setList):
            for j in range(i - 1, -1, -1):
                if len(st & setList[j]) >= k:
                    union(i, j)
        return cnt

    def minTime(self, skill: List[int], mana: List[int]) -> int:
        n = len(skill)
        times = [0] * n
        diff = 0
        pre_diff = 0
        for ma in mana:
            cur = times[0] + diff
            pre_diff = diff
            diff = 0
            for i in range(n):
                times[i] += pre_diff
                if cur < times[i]:
                    diff += times[i] - cur
                    cur = times[i]
                cur += skill[i] * ma
                times[i] = cur - diff
        return times[-1] + diff


# print(Solution().minTime([2, 8, 8, 6], [8, 7, 10, 3]))
print(Solution().minTime([1, 5, 2, 4], [5, 1, 4, 2]))
