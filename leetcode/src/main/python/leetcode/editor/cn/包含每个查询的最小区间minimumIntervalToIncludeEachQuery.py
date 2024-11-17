"""
Title: 1851.包含每个查询的最小区间
Title Slug: minimumIntervalToIncludeEachQuery
Author: Neo
Date: 2024-11-17 20:42:15
"""
import heapq
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        itv = sorted(intervals, key=lambda x: x[0])
        ans = [-1] * len(queries)
        idx = 0
        h = []
        for i, q in sorted(enumerate(queries), key=lambda x: x[1]):
            while idx < len(itv) and itv[idx][0] <= q:
                width = itv[idx][1] - itv[idx][0] + 1
                heapq.heappush(h, (width, itv[idx]))
                idx += 1
            while h and h[0][1][1] < q:
                heapq.heappop(h)
            if h:
                ans[i] = h[0][0]
        return ans
# leetcode submit region end(Prohibit modification and deletion)
Solution().minInterval([[4,5],[5,8],[1,9],[8,10],[1,6]],[7,9,3,9,3])