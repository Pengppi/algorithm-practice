"""
Title: 51.N 皇后
Title Slug: nQueens
Author: Neo
Date: 2024-12-01 01:05:58
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        ans = []

        def check(vis: List[int], i: int):
            for j in range(i):
                if vis[j] == vis[i] or abs(vis[j] - vis[i]) == i - j:
                    return False
            return True

        def dfs(x: int, vis: List[int]):
            if x == n:
                ans.append(["." * i + "Q" + "." * (n - i - 1) for i in vis])
                return
            for y in range(n):
                vis[x] = y
                if check(vis, x):
                    dfs(x + 1, vis)

        dfs(0, [0] * n)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
