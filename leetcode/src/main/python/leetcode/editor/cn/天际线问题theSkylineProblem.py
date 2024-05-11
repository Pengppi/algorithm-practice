"""
Title: 218.天际线问题
Title Slug: theSkylineProblem
Author: Neo
Date: 2024-05-10 17:13:43
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        ps = []
        for l, r, h in buildings:
            ps.append([l, -h])
            ps.append([r, h])
        ps.sort(key=lambda x: (x[0], x[1]))
        heap = [0]
        prev = 0
        ans = []
        for p, h in ps:
            if h < 0:
                heapq.heappush(heap, h)
            else:
                heap.remove(-h)
                heapq.heapify(heap)
            cur_height = -heap[0]
            if cur_height != prev:
                ans.append([p, cur_height])
                prev = cur_height
        return ans


# leetcode submit region end(Prohibit modification and deletion)
Solution().getSkyline([[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]])
