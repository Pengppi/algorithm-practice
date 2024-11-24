"""
Title: 632.最小区间
Title Slug: smallestRangeCoveringElementsFromKLists
Author: Neo
Date: 2024-11-24 17:06:23
"""
import heapq
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        q = [(arr[0], i, 0) for i, arr in enumerate(nums)]
        heapq.heapify(q)

        ansl = q[0][0]
        ansr = r = max(arr[0] for arr in nums)
        while q[0][2] + 1 < len(nums[q[0][1]]):
            _, i, j = q[0]
            x = nums[i][j + 1]
            heapq.heapreplace(q, (x, i, j + 1))
            r = max(r, x)
            l = q[0][0]
            if r - l < ansr - ansl:
                ansl, ansr = l, r
        return [ansl, ansr]
# leetcode submit region end(Prohibit modification and deletion)
