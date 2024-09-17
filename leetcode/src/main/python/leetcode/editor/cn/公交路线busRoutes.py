"""
Title: 815.公交路线
Title Slug: busRoutes
Author: Neo
Date: 2024-09-17 15:21:07
"""
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        if source == target:
            return 0
        n = len(routes)
        mp = defaultdict(list)
        for i, route in enumerate(routes):
            for r in route:
                mp[r].append(i)
        vis = [False] * n
        cur = mp[source]
        for x in cur:
            vis[x] = True
        ans = 1
        while cur:
            next = []
            for x in cur:
                for y in routes[x]:
                    if y == target:
                        return ans
                    for z in mp[y]:
                        if not vis[z]:
                            vis[z] = True
                            next.append(z)
                    if mp[y]:
                        mp[y] = []
            ans += 1
            cur = next
        return -1


# leetcode submit region end(Prohibit modification and deletion)
x = Solution().numBusesToDestination(
    [[1, 9, 12, 20, 23, 24, 35, 38], [10, 21, 24, 31, 32, 34, 37, 38, 43], [10, 19, 28, 37], [8], [14, 19],
     [11, 17, 23, 31, 41, 43, 44], [21, 26, 29, 33], [5, 11, 33, 41], [4, 5, 8, 9, 24, 44]]
    , 37, 28)
print(x)
