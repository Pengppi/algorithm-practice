"""
Title: 2221.Find Triangular Sum of an Array
Title Slug: findTriangularSumOfAnArray
Author: Neo
Date: 2025-09-30 12:37:33
"""
from collections import deque
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        q = deque(nums)
        while len(q) > 1:
            x = q.popleft()
            for _ in range(len(q) - 1, -1, -1):
                y = q.popleft()
                q.append((x + y) % 10)
                x = y
        return q[0]

# leetcode submit region end(Prohibit modification and deletion)
