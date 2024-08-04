from collections import defaultdict
from typing import List


class Solution:
    def winningPlayerCount(self, n: int, pick: List[List[int]]) -> int:
        pick.sort()
        last = pick[0][0]
        mp = defaultdict(int)
        st = set()
        for x, y in pick:
            if x != last:
                mp.clear()
                last = x
            mp[y] += 1
            if mp[y] > x:
                st.add(x)
        return len(st)

    def minFlips2(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        cnt1 = 0
        for i in range(m):
            l, r = 0, n - 1
            while l < r:
                if grid[i][l] != grid[i][r]:
                    cnt1 += 1
                l += 1
                r -= 1
        cnt2 = 0
        for j in range(n):
            l, r = 0, m - 1
            while l < r:
                if grid[l][j] != grid[r][j]:
                    cnt2 += 1
                l += 1
                r -= 1
        return min(cnt1, cnt2)


