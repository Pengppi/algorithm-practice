"""
Title: 3264.K 次乘运算后的最终数组 I
Title Slug: finalArrayStateAfterKMultiplicationOperationsI
Author: Neo
Date: 2024-12-13 22:07:31
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        q = [(x, i) for i, x in enumerate(nums)]
        heapq.heapify(q)
        for _ in range(k):
            heapq.heapreplace(q, (q[0][0] * multiplier, q[0][1]))
        return [x for x, _ in sorted(q, key=lambda x: x[1])]
# leetcode submit region end(Prohibit modification and deletion)
