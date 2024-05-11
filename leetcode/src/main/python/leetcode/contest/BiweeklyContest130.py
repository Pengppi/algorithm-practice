"""
https://leetcode.cn/contest/biweekly-contest-130
"""
import math
from math import sqrt
from typing import List


class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        ans = 0

        return 0


    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        ps = [i for i in range(len(points))]
        ps.sort(key=lambda i: (max(abs(points[i][0]), abs(points[i][1]))))
        s_set = set()
        last, cnt, ans = 0, 0, 0
        for i in ps:
            cur_dict = max(abs(points[i][0]), abs(points[i][1]))
            if cur_dict != last:
                ans += cnt
                last = cur_dict
                cnt = 1
            else:
                cnt += 1
            if s[i] in s_set:
                cnt = 0
                break
            s_set.add(s[i])
            print(i)
        return ans + cnt

    def satisfiesConditions(self, grid: List[List[int]]) -> bool:
        m, n = len(grid), len(grid[0])
        for i in range(m):
            for j in range(n):
                if i + 1 < m and grid[i][j] != grid[i + 1][j]:
                    return False
                if j + 1 < n and grid[i][j] == grid[i][j + 1]:
                    return False
        return True
