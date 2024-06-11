"""
Title: LCR 060.前 K 个高频元素
Title Slug: g5c51o
Author: Neo
Date: 2024-06-11 12:41:23
"""
import collections
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        nums.sort()
        pq = []
        last, last_cnt = nums[0], 1
        for i in range(1, len(nums)):
            if nums[i] == last:
                last_cnt += 1
            else:
                heapq.heappush(pq, (last_cnt, last))
                if len(pq) > k:
                    heapq.heappop(pq)
                last = nums[i]
                last_cnt = 1
        heapq.heappush(pq, (last_cnt, last))
        if len(pq) > k:
            heapq.heappop(pq)
        return [b for a, b in pq]

# leetcode submit region end(Prohibit modification and deletion)
