"""
Title: 2208.将数组和减半的最少操作次数
Title Slug: minimumOperationsToHalveArraySum
Author: Neo
Date: 2024-11-17 20:28:01
"""
import heapq
from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def halveArray(self, nums: List[int]) -> int:
        t = sum(nums) / 2
        q = [-x for x in nums]
        heapq.heapify(q)
        ans = 0

        while t > 0:
            mx = heapq.heappop(q)
            left = mx / 2
            t += left
            heapq.heappush(q, left)
            ans += 1
        return ans

# leetcode submit region end(Prohibit modification and deletion)
