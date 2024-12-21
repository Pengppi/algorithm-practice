"""
Title: 3266.K 次乘运算后的最终数组 II
Title Slug: finalArrayStateAfterKMultiplicationOperationsIi
Author: Neo
Date: 2024-12-14 22:59:48
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        if multiplier == 1:
            return nums
        mod = 10 ** 9 + 7
        n = len(nums)
        mx = max(nums)
        q = [(x, i) for i, x in enumerate(nums)]
        heapq.heapify(q)
        while k and q[0][0] < mx:
            k -= 1
            heapq.heapreplace(q, (q[0][0] * multiplier, q[0][1]))
        q.sort()
        for i, (x, j) in enumerate(q):
            nums[j] = x * pow(multiplier, k // n + (i < k % n), mod) % mod

        return nums
# leetcode submit region end(Prohibit modification and deletion)
