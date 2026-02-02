"""
Title: 2977.Minimum Cost to Convert String II
Title Slug: minimumCostToConvertStringIi
Author: Neo
Date: 2026-01-30 20:29:57
"""

# leetcode submit region begin(Prohibit modification and deletion)
from collections import defaultdict
from functools import cache
from math import inf
from typing import List


class Solution:

    def minimumCost(self, source: str, target: str, original: List[str],
                    changed: List[str], cost: List[int]) -> int:
        len2strs = defaultdict(set)
        dis = defaultdict(lambda: defaultdict(lambda: inf))
        for x, y, c in zip(original, changed, cost):
            len2strs[len(x)].add(x)
            len2strs[len(y)].add(y)
            dis[x][y] = min(dis[x][y], c)
            dis[x][x] = 0
            dis[y][y] = 0

        for strs in len2strs.values():
            for k in strs:
                for x in strs:
                    if dis[x][k] == inf:
                        continue
                    for y in strs:
                        dis[x][y] = min(dis[x][y], dis[x][k] + dis[k][y])

        @cache
        def dfs(i: int) -> int:
            if i == 0:
                return 0
            res = inf
            if source[i - 1] == target[i - 1]:
                res = dfs(i - 1)
            for sz, strs in len2strs.items():
                if i < sz:
                    continue
                s = source[i - sz:i]
                t = target[i - sz:i]
                if s in strs and t in strs:
                    res = min(res, dis[s][t] + dfs(i - sz))
            return res  # type: ignore

        ans = dfs(len(source))
        return ans if ans < inf else -1


# leetcode submit region end(Prohibit modification and deletion)
