"""
Title: 3244.新增道路查询后的最短距离 II
Title Slug: shortestDistanceAfterRoadAdditionQueriesIi
Author: Neo
Date: 2024-11-20 00:17:37
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        fa = list(range(n - 1))

        def find(x: int):
            if fa[x] != x:
                fa[x] = find(fa[x])
            return fa[x]

        ans = []
        cnt = n - 1
        for l, r in queries:
            rr = find(r - 1)
            i = find(l)
            while i < r - 1:
                cnt -= 1
                fa[i] = rr
                i = find(i + 1)
            ans.append(cnt)
        return ans

# leetcode submit region end(Prohibit modification and deletion)
