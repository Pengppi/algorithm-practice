"""
Title: 2050.并行课程 III
Title Slug: parallelCoursesIii
Author: Neo
Date: 2024-10-02 14:52:44
"""
import heapq
from collections import defaultdict
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        cnt = defaultdict(int)
        g = defaultdict(list)
        for (i, j) in relations:
            cnt[j] += 1
            g[i].append(j)

        q = []
        for i in range(1, n + 1):
            if i not in cnt:
                q.append((time[i - 1], i))

        heapq.heapify(q)
        ans = 0
        while q:
            t, i = heapq.heappop(q)
            ans = t
            for j in g[i]:
                cnt[j] -= 1
                if cnt[j] == 0:
                    heapq.heappush(q, (t + time[j - 1], j))
                    del cnt[j]
        return ans

            # leetcode submit region end(Prohibit modification and deletion)
