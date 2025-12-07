"""
Title: 3625.Count Number of Trapezoids II
Title Slug: countNumberOfTrapezoidsIi
Author: Neo
Date: 2025-12-03 17:51:20
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:

    def countTrapezoids(self, points: List[List[int]]) -> int:
        groups = defaultdict(list)  # 斜率 -> [截距]
        groups2 = defaultdict(list)  # 中点 -> [斜率]

        for i, (x, y) in enumerate(points):
            for x2, y2 in points[:i]:
                dy = y - y2
                dx = x - x2
                k = dy / dx if dx else inf
                b = (y * dx - x * dy) / dx if dx else x
                groups[k].append(b)
                groups2[(x + x2, y + y2)].append(k)

        ans = 0
        for g in groups.values():
            if len(g) == 1:
                continue
            s = 0
            for c in Counter(g).values():
                ans += s * c
                s += c

        for g in groups2.values():
            if len(g) == 1:
                continue
            s = 0
            for c in Counter(g).values():
                ans -= s * c  # 平行四边形会统计两次，减去多统计的一次
                s += c

        return ans


# leetcode submit region end(Prohibit modification and deletion)
