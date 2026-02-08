"""
Title: 3013.Divide an Array Into Subarrays With Minimum Cost II
Title Slug: divideAnArrayIntoSubarraysWithMinimumCostIi
Author: Neo
Date: 2026-02-02 20:40:56
"""

from typing import List

from sortedcontainers import SortedList


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumCost(self, nums: List[int], k: int, dist: int) -> int:
        n = len(nums)
        sumLeft = sum(nums[: dist + 2])
        left = SortedList(nums[1 : dist + 2])
        right = SortedList()
        k -= 1

        def l2r() -> None:
            x = left.pop()
            nonlocal sumLeft
            sumLeft -= x
            right.add(x)

        def r2l() -> None:
            x = right.pop(0)
            nonlocal sumLeft
            sumLeft += x
            left.add(x)

        while len(left) > k:
            l2r()

        ans = sumLeft
        for i in range(dist + 2, n):
            out = nums[i - dist - 1]
            if out in left:
                sumLeft -= out
                left.remove(out)
            else:
                right.remove(out)

            in_val = nums[i]
            if in_val < left[-1]:  # pyright: ignore[reportOperatorIssue]
                left.add(in_val)
                sumLeft += in_val
            else:
                right.add(in_val)

            if len(left) == k - 1:
                r2l()
            elif len(left) == k + 1:
                l2r()

            ans = min(ans, sumLeft)
        return ans


# leetcode submit region end(Prohibit modification and deletion)
