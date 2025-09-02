"""
Title: 3025.Find the Number of Ways to Place People I
Title Slug: findTheNumberOfWaysToPlacePeopleI
Author: Neo
Date: 2025-09-02 12:53:05
"""
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def numberOfPairs(self, points: List[List[int]]) -> int:
        ans = 0
        points.sort(key=lambda p: (p[0], -p[1]))
        n = len(points)
        for i in range(n - 1):
            mn = -1
            for j in range(i + 1, n):
                if points[j][1] > points[i][1] and points[j][0] > points[i][0]:
                    continue
                if points[j][1] > mn:
                    mn = points[j][1]
                    ans += 1

        return ans

# leetcode submit region end(Prohibit modification and deletion)
