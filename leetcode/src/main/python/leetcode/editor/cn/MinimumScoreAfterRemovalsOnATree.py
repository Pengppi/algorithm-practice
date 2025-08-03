"""
Title: 2322.Minimum Score After Removals on a Tree
Title Slug: minimumScoreAfterRemovalsOnATree
Author: Neo
Date: 2025-07-24 15:13:28
"""
from cmath import inf
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumScore(self, nums: List[int], edges: List[List[int]]) -> int:
        n = len(nums)
        g = [[] for _ in range(n)]

        for u, v in edges:
            g[u].append(v)
            g[v].append(u)

        xor = [0] * n
        in_time = [0] * n
        out_time = [0] * n
        clock = 0

        def dfs(x, fa):
            nonlocal clock
            clock += 1
            in_time[x] = clock

            cur_xor = nums[x]
            for y in g[x]:
                if y == fa:
                    continue
                cur_xor ^= dfs(y, x)
            xor[x] = cur_xor
            out_time[x] = clock
            return cur_xor

        dfs(0, -1)

        def is_ancestor(x, y):
            return in_time[x] <= in_time[y] and out_time[x] >= out_time[y]

        ans = inf
        for i in range(1, n - 1):
            for j in range(i + 1, n):
                if is_ancestor(i, j):
                    a, b, c = xor[j], xor[i] ^ xor[j], xor[0] ^ xor[i]
                elif is_ancestor(j, i):
                    a, b, c = xor[i], xor[j] ^ xor[i], xor[0] ^ xor[j]
                else:
                    a, b, c = xor[i], xor[j], xor[0] ^ xor[i] ^ xor[j]

                ans = min(ans, max(a, b, c) - min(a, b, c))
                if ans == 0:
                    return 0
        return ans

        # leetcode submit region end(Prohibit modification and deletion)
