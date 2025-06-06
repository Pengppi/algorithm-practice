"""
Title: 3362.零数组变换 III
Title Slug: zeroArrayTransformationIii
Author: Neo
Date: 2025-05-22 20:23:59
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def maxRemoval(self, nums: List[int], queries: List[List[int]]) -> int:
        queries.sort(key=lambda q: q[0])
        n = len(nums)
        m = len(queries)
        diff = [0] * (n + 1)
        sum_diff = j = 0
        h = []
        for i, x in enumerate(nums):
            sum_diff += diff[i]
            while j < m and queries[j][0] <= i:
                heapq.heappush(h, -queries[j][1])
                j += 1

            while sum_diff < x and h and -h[0] >= i:
                r = -heapq.heappop(h)
                sum_diff += 1
                diff[r + 1] -= 1
            if sum_diff < x:
                return -1
        return len(h)

# leetcode submit region end(Prohibit modification and deletion)
