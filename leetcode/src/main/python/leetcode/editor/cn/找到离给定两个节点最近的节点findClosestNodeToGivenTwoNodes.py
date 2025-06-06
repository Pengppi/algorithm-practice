"""
Title: 2359.找到离给定两个节点最近的节点
Title Slug: findClosestNodeToGivenTwoNodes
Author: Neo
Date: 2025-05-30 09:42:56
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        n = len(edges)

        def get_dis(cur: int) -> List[int]:
            dis = [n] * n
            d = 0
            while cur >= 0 and dis[cur] == n:
                dis[cur] = d
                d += 1
                cur = edges[cur]
            return dis

        dis1 = get_dis(node1)
        dis2 = get_dis(node2)
        mn = n
        ans = -1
        for i, (d1, d2) in enumerate(zip(dis1, dis2)):
            d = max(d1, d2)
            if d < mn:
                mn = d
                ans = i
        return ans

    # leetcode submit region end(Prohibit modification and deletion)
