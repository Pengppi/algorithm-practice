"""
Title: 1659.最大化网格幸福感
Title Slug: maximizeGridHappiness
Author: Neo
Date: 2025-01-01 16:02:03
"""
from functools import cache


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getMaxGridHappiness(self, m: int, n: int, introvertsCount: int, extrovertsCount: int) -> int:
        mx = pow(3, n)
        f = [0] * mx  # 行内得分
        g = [[0] * mx for _ in range(mx)]  # 行间得分
        ic = [0] * mx
        ec = [0] * mx
        h = [
            [0, 0, 0],
            [0, -60, -10],
            [0, -10, 40]
        ]
        bits = [[0] * n for _ in range(mx)]
        for i in range(mx):
            mask = i
            for j in range(n):
                mask, x = divmod(mask, 3)
                bits[i][j] = x
                if x == 1:
                    ic[i] += 1
                    f[i] += 120
                elif x == 2:
                    ec[i] += 1
                    f[i] += 40
                if j:
                    f[i] += h[x][bits[i][j - 1]]
        for i in range(mx):
            for j in range(mx):
                for k in range(n):
                    g[i][j] += h[bits[i][k]][bits[j][k]]

        @cache
        def dfs(row, pre, intro, extro):
            if row == m or intro == 0 and extro == 0:
                return 0
            res = 0
            for cur in range(mx):
                if ic[cur] > intro or ec[cur] > extro:
                    continue
                a = f[cur] + g[pre][cur]
                b = dfs(row + 1, cur, intro - ic[cur], extro - ec[cur])
                res = max(res, a + b)
            return res
        return dfs(0,0,introvertsCount,extrovertsCount)

# leetcode submit region end(Prohibit modification and deletion)
