import heapq
from collections import defaultdict
from typing import List


class Solution:
    def isBalanced(self, num: str) -> bool:
        odd, even = 0, 0
        for i, c in enumerate(num):
            if i & 1:
                odd += int(c)
            else:
                even += int(c)
        return odd == even

    def minTimeToReach1(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        f = [[float('inf')] * m for _ in range(n)]
        f[0][0] = 0
        q = [(0, 0, 0)]
        dirs = [0, -1, 0, 1, 0]
        while q:
            t, i, j = heapq.heappop(q)
            if t > f[i][j]:
                continue
            for k in range(4):
                x, y = i + dirs[k], j + dirs[k + 1]
                if 0 <= x < n and 0 <= y < m:
                    nt = max(t, moveTime[x][y]) + 1
                    if x == n - 1 and y == m - 1:
                        return nt
                    if f[x][y] > nt:
                        f[x][y] = nt
                        heapq.heappush(q, (nt, x, y))

        return -1

    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        f = [[float('inf')] * m for _ in range(n)]
        f[0][0] = 0
        q = [(0, 0, 0, 1)]
        dirs = [0, -1, 0, 1, 0]
        while q:
            t, i, j, c = heapq.heappop(q)
            if t > f[i][j]:
                continue
            for k in range(4):
                x, y = i + dirs[k], j + dirs[k + 1]
                cost = 1 if c & 1 else 2
                nc = c ^ 1
                if 0 <= x < n and 0 <= y < m:
                    nt = max(t, moveTime[x][y]) + cost
                    if x == n - 1 and y == m - 1:
                        return nt
                    if f[x][y] > nt:
                        f[x][y] = nt
                        heapq.heappush(q, (nt, x, y, nc))
        return -1

    def countBalancedPermutations(self, num: str) -> int:
        n = len(num)
        mod = 10 ** 9 + 7
        s = 0
        mp = defaultdict(int)
        for c in num:
            ic = int(c)
            mp[ic] += 1
            s += ic
        limit = s // 2

        def dfs(i, odd, even):
            if i == n:
                return 1 if odd == even else 0
            if odd > limit or even > limit:
                return 0
            res = 0
            for (k, v) in mp.items():
                if v > 0:
                    mp[k] -= 1
                    nodd = odd + k if i & 1 else odd
                    neven = even if i & 1 else even + k
                    res += dfs(i + 1, nodd, neven)
                    mp[k] += 1
            return res % mod

        return dfs(0, 0, 0)
