"""
Title: 407.Trapping Rain Water II
Title Slug: trappingRainWaterIi
Author: Neo
Date: 2025-10-03 10:33:15
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        m, n = len(heightMap), len(heightMap[0])
        h = []
        for i, row in enumerate(heightMap):
            for j, x in enumerate(row):
                if i == 0 or i == m - 1 or j == 0 or j == n - 1:
                    h.append((x, i, j))
                    row[j] = -1

        heapq.heapify(h)
        ans = 0
        dirs = [1, 0, -1, 0, 1]
        while h:
            min_h, i, j = heapq.heappop(h)
            for k in range(4):
                x, y = i + dirs[k], j + dirs[k + 1]
                if x < 0 or x >= m or y < 0 or y >= n or heightMap[x][y] < 0:
                    continue
                cur_h = heightMap[x][y]
                heightMap[x][y] = -1
                if cur_h < min_h:
                    ans += min_h - cur_h
                heapq.heappush(h, (max(cur_h, min_h), x, y))

        return ans

    # leetcode submit region end(Prohibit modification and deletion)
